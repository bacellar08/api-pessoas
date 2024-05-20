package com.pessoas.api.consultapessoas.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String logradouro;
    public Long cep;
    public Long numero;
    public String cidade;
    public String estado;
    public boolean principal;


    @ManyToOne
    @JoinColumn(name = "ID_PESSOA", nullable = false)
    @JsonIgnore
    public Pessoa idPessoa;


}
