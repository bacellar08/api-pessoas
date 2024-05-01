package com.pessoas.api.consultapessoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PessoaService service;

    @GetMapping("/pessoas")
    public List<Pessoa> listaPessoas() {
        return service.listaPessoas();
    }

    @GetMapping("/{id}")
    public Pessoa findById(@PathVariable("id")Long id) {

        return service.acharPessoa(id);
    }

    @PostMapping
    public ResponseEntity<Pessoa> novaPessoa(@RequestBody Pessoa pessoa) {

        for (Endereco endereco : pessoa.getEnderecos()) {
            endereco.setPessoa(pessoa);

        }

        Pessoa novaPessoa = service.criarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);

    }

    @PutMapping
    public Pessoa alterarPessoa(@RequestBody Pessoa pessoa) {
        return service.alterarPessoa(pessoa);
    }

    @PutMapping("/{pessoaId}/{enderecoId}")
    public ResponseEntity<Pessoa> setEnderecoPrincipal(@PathVariable("pessoaId") Long pessoaId, @PathVariable("enderecoId") Long enderecoId) {
        service.setEnderecoPrincipal(pessoaId, enderecoId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void excluirPessoa(@PathVariable("id")Long id) {
        service.excluirPessoa(id);
    }
}
