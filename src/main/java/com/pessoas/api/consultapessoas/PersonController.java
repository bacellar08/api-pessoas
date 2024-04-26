package com.pessoas.api.consultapessoas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @GetMapping("/pessoas")
    public List<Pessoa> findAll() {

        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public Pessoa findById(@PathVariable("id")Long id) {

        return new Pessoa();
    }

    @PostMapping
    public Pessoa novaPessoa(Pessoa pessoa) {
        return new Pessoa();
    }
}
