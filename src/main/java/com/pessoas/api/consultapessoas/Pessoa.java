package com.pessoas.api.consultapessoas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public Date dataNascimento;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Endereco> enderecos;
}
