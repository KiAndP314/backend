package com.generation.backend.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.generation.backend.auth.dto.FullCredentialDTO;
import com.generation.backend.auth.dto.UAIMapper;
import com.generation.backend.auth.dto.UserAdditionalInfoDTO;
import com.generation.backend.auth.model.UserAdditionalInfo;
import com.generation.backend.dto.UserInfoDTO;

@Service
public class AdditionalInfoService {

    private UAIMapper mapper = UAIMapper.ISTANCE;

    public UserInfoDTO toDTO(UserAdditionalInfo userAdditionalInfo) {
        UserInfoDTO res = new UserInfoDTO();
        res.setNome(userAdditionalInfo.getNome());
        res.setCognome(userAdditionalInfo.getCognome());
        res.setDob(userAdditionalInfo.getDob());
        return res;
    }

    public UserAdditionalInfo toEntity(FullCredentialDTO userAdditionalInfoDTO) {
        return mapper.toEntity(userAdditionalInfoDTO);
    }



}
