package com.pessoas.api.consultapessoas.repository;

import com.pessoas.api.consultapessoas.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
