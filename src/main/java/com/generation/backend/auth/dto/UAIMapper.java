package com.generation.backend.auth.dto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.generation.backend.auth.dto.mapper.AbbonamentoMapper;
import com.generation.backend.auth.model.UserAdditionalInfo;
import com.generation.backend.dto.UtenteDTO;

@Mapper(uses = {AbbonamentoMapper.class})
public interface UAIMapper {
    public static final UAIMapper ISTANCE = Mappers.getMapper(UAIMapper.class);

    // public UserAdditionalInfo toEntity(FullCredentialDTO fullCredentialDTO);

    @Mapping(source = "user.email", target = "email")
    // @Mapping(source = "palestra.nome", target = "nomePalestra")
    public UtenteDTO toDTO(UserAdditionalInfo userAdditionalInfo);

    
    @Mapping(target = "abbonamenti", ignore = true)
    @Mapping(target = "certificato", ignore = true)
    @Mapping(target = "id", ignore = true)
    // @Mapping(target = "palestra", ignore = true)
    @Mapping(target = "user", ignore = true)
    UserAdditionalInfo toEntity(FullCredentialDTO fullCredentialDTO);

    // non serve
    // @InheritInverseConfiguration
    // @Mapping(target = "id", ignore = true)
    // @Mapping(target = "palestra", ignore = true)
    // @Mapping(target = "user", ignore = true)

    // @Mapping(source = "email", target = "user.email")
    // @Mapping(source = "nomePalestra", target = "palestra.nome")
    // public UserAdditionalInfo toEntity(UtenteDTO utenteDTO);

    

    // @Mapping(source = "dob",target = "dob", dateFormat = "yyyy-MM-dd")
    // StudentDTO toDTO(Student s);

    // @Mapping(target = "createdDate", ignore = true)
    // @Mapping(target = "lastModifiedDate", ignore = true)
    // @Mapping(source = "dob",target = "dob", dateFormat = "yyyy-MM-dd")
    // @Mapping(target ="gradesReceived", ignore = true)
    // Student toEntity(StudentDTO dto);

}
