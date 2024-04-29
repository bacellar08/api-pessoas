package com.pessoas.api.consultapessoas;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
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
    @JoinColumn(name="pessoa_id")
    @JsonBackReference
    public Pessoa pessoa;


}
