package com.pessoas.api.consultapessoas;

import com.pessoas.api.consultapessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public List<Pessoa> listaPessoas() {
        return repository.findAll();
    }

    public Pessoa acharPessoa(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    public Pessoa criarPessoa(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public Pessoa alterarPessoa(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public void excluirPessoa(Long id) {
        repository.deleteById(id);
    }


}
