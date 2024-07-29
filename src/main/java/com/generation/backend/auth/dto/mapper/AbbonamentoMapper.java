package com.generation.backend.auth.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.generation.backend.dto.AbbonamentoDTO;
import com.generation.backend.model.Abbonamento;

@Mapper
public interface AbbonamentoMapper {
    public static final AbbonamentoMapper INSTANCE = Mappers.getMapper(AbbonamentoMapper.class);

    @Mapping(source = "corso.nome", target = "nomeCorso")
    @Mapping(source = "corso.dataFine", target = "dataScadenza")
    AbbonamentoDTO toDTO(Abbonamento abbonamento);


    // non serve
    // @Mapping(source = "nomeCorso", target = "corso.nome")
    // @Mapping(source = "dataScadenza", target = "corso.dataFine")
    // Abbonamento toEntity(AbbonamentoDTO abbonamentoDTO);
}
