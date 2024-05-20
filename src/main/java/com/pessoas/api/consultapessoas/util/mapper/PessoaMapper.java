package com.pessoas.api.consultapessoas.util.mapper;


import com.pessoas.api.consultapessoas.model.Pessoa;
import com.pessoas.api.consultapessoas.model.dto.PessoaDTO;
import lombok.Getter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

import java.time.LocalDate;
import java.time.Period;


public class PessoaMapper {

    @Getter
    private static final ModelMapper mapper = createMapper();

    private static ModelMapper createMapper() {
        ModelMapper mapper = new ModelMapper();



//            Converter<LocalDate, Integer> idadeConverter = new Converter<LocalDate, Integer>() {
//
//                @Override
//                public Integer convert(MappingContext<LocalDate, Integer> context) {
//                    LocalDate dataNascimento = context.getSource();
//                    LocalDate dataAtual = LocalDate.now();
//                    return Period.between(dataNascimento, dataAtual).getYears();
//                }
//            };

            mapper.createTypeMap(
                            Pessoa.class,
                            PessoaDTO.class)
                    .addMapping(Pessoa::getId, PessoaDTO::setKey);
//                    .addMappings(mapping -> mapping.using(idadeConverter).map(Pessoa::getDataNascimento, PessoaDTO::setIdade));


        return mapper;
    }

}
