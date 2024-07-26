package com.generation.backend.auth.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.generation.backend.auth.model.UserAdditionalInfo;

@Mapper
public interface UAIMapper {
    public static final UAIMapper ISTANCE = Mappers.getMapper(UAIMapper.class);

    public UserAdditionalInfo toEntity(FullCredentialDTO fullCredentialDTO);

    // @Mapping(source = "dob",target = "dob", dateFormat = "yyyy-MM-dd")
    // StudentDTO toDTO(Student s);

    // @Mapping(target = "createdDate", ignore = true)
    // @Mapping(target = "lastModifiedDate", ignore = true)
    // @Mapping(source = "dob",target = "dob", dateFormat = "yyyy-MM-dd")
    // @Mapping(target ="gradesReceived", ignore = true)
    // Student toEntity(StudentDTO dto);

}
