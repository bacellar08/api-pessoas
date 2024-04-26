package com.pessoas.api.consultapessoas;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {

    private String logradouro;
    @Id
    private Long cep;
    private Long numero;
    private String cidade;
    private String estado;
    private boolean principal;

    @ManyToOne
    private Pessoa pessoa;


}
