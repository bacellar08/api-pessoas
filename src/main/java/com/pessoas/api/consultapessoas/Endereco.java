package com.pessoas.api.consultapessoas;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String logradouro;
    private Long cep;
    private Long numero;
    private String cidade;
    private String estado;


}
