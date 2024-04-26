package com.pessoas.api.consultapessoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public Pessoa novaPessoa(@RequestBody Pessoa pessoa) {
        return service.criarPessoa(pessoa);
    }

    @PutMapping
    public Pessoa alterarPessoa(@RequestBody Pessoa pessoa) {
        return service.alterarPessoa(pessoa);
    }

    @DeleteMapping("/{id}")
    public void excluirPessoa(@PathVariable("id")Long id) {
        service.excluirPessoa(id);
    }
}
