package com.pessoas.api.consultapessoas;

import com.pessoas.api.consultapessoas.model.Endereco;
import com.pessoas.api.consultapessoas.model.Pessoa;
import com.pessoas.api.consultapessoas.model.dto.PessoaDTO;
import com.pessoas.api.consultapessoas.repository.PessoaRepository;
import com.pessoas.api.consultapessoas.util.mapper.PessoaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public List<PessoaDTO> listaPessoas() {
        return repository.findAll().stream().map(pessoa -> {
            PessoaDTO pessoaDTO = PessoaMapper.getMapper().map(pessoa, PessoaDTO.class);
            return pessoaDTO;
        }).collect(Collectors.toList());
    }

    public PessoaDTO acharPessoa(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        return PessoaMapper.getMapper().map(entity, PessoaDTO.class);
    }

    public PessoaDTO criarPessoa(PessoaDTO pessoa) {

        Pessoa entity = PessoaMapper.getMapper().map(pessoa, Pessoa.class);

        for (Endereco endereco : entity.getEnderecos()) {
            endereco.setIdPessoa(entity);
        }

        var novaPessoa = repository.save(entity);

        Endereco enderecoPrincipal = novaPessoa.getEnderecos().get(0);
        enderecoPrincipal.setPrincipal(true);
        novaPessoa.setIdEnderecoPrincipal(enderecoPrincipal.getId());

        var persisted = repository.save(novaPessoa);

        return PessoaMapper.getMapper().map(persisted, PessoaDTO.class);

    }

    public PessoaDTO alterarPessoa(PessoaDTO pessoa) {
        var target = repository.findById(pessoa.getKey()).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        target.setNome(pessoa.getNome());
        target.setDataNascimento(pessoa.getDataNascimento());

        for (Endereco endereco : pessoa.getEnderecos()) {
            endereco.setIdPessoa(target);
        }
        target.setEnderecos(pessoa.getEnderecos());
        target.setIdEnderecoPrincipal(pessoa.getIdEnderecoPrincipal());

        var persisted = repository.save(target);

        return PessoaMapper.getMapper().map(persisted, PessoaDTO.class);

    }

    @Transactional
    public void setEnderecoPrincipal(Long pessoaId, Long enderecoId) {
        Pessoa pessoa = repository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        for (Endereco endereco : pessoa.getEnderecos()) {
            if (endereco.getId().equals(enderecoId)) {
                endereco.setPrincipal(true);
            } else {
                endereco.setPrincipal(false);
            }
        }

        repository.save(pessoa);
    }

    public void excluirPessoa(Long id) {
        repository.deleteById(id);
    }


}
