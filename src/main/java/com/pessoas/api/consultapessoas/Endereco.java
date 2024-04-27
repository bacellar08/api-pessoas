package com.pessoas.api.consultapessoas;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {
    @Id
    private Long id;
    private String logradouro;
    private Long cep;
    private Long numero;
    private String cidade;
    private String estado;
    private boolean principal;

    @ManyToOne
    @JoinColumn(name="pessoa_id")
    private Pessoa pessoa;


}
