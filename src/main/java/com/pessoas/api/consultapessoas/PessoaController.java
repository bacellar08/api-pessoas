package com.pessoas.api.consultapessoas;

import com.pessoas.api.consultapessoas.model.Pessoa;
import com.pessoas.api.consultapessoas.model.dto.PessoaDTO;
import com.pessoas.api.consultapessoas.util.mapper.PessoaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaService service;

    @GetMapping()
    public ResponseEntity<List<PessoaDTO>> listaPessoas() {
        var pessoas = service.listaPessoas();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable("id")Long id) {
        var pessoa = service.acharPessoa(id);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> novaPessoa(@RequestBody PessoaDTO pessoa) {


        PessoaDTO novaPessoa = service.criarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);

    }

    @PutMapping
    public ResponseEntity<PessoaDTO> alterarPessoa(@RequestBody PessoaDTO pessoa) {

        var updatedPerson = service.alterarPessoa(pessoa);
        return ResponseEntity.ok(updatedPerson);
    }

    @PutMapping("/{pessoaId}/{enderecoId}")
    public ResponseEntity<Pessoa> setEnderecoPrincipal(@PathVariable("pessoaId") Long pessoaId, @PathVariable("enderecoId") Long enderecoId) {
        service.setEnderecoPrincipal(pessoaId, enderecoId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable("id")Long id) {
        service.excluirPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
