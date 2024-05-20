package com.pessoas.api.consultapessoas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public LocalDate dataNascimento;

    @OneToMany(mappedBy = "idPessoa", cascade = CascadeType.ALL)
    public List<Endereco> enderecos;

    @Column(name = "ID_ENDERECO_PRINCIPAL")
    public Long idEnderecoPrincipal;

}
