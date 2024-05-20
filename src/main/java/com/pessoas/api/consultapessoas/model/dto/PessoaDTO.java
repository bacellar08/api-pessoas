package com.pessoas.api.consultapessoas.model.dto;


import com.pessoas.api.consultapessoas.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO implements Serializable {

    public Long key;
    public String nome;
    public LocalDate dataNascimento;
    public List<Endereco> enderecos;
    public Long idEnderecoPrincipal;
}
