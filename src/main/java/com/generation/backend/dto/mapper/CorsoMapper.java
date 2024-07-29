package com.generation.backend.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.generation.backend.dto.CorsoDTO;
import com.generation.backend.dto.CorsoDescriptionDTO;
import com.generation.backend.model.Corso;

@Mapper
public interface CorsoMapper {

    public static final CorsoMapper INSTANCE = Mappers.getMapper(CorsoMapper.class);

    // @Mapping(source = "dataFine", target = "scadenza")
    CorsoDescriptionDTO toCorsoDescriptionDTO(Corso corso);

    CorsoDTO toDTO(Corso corso);
}
