package com.generation.backend.service;

import org.springframework.stereotype.Service;

import com.generation.backend.auth.dto.FullCredentialDTO;
import com.generation.backend.auth.dto.UAIMapper;
import com.generation.backend.auth.model.UserAdditionalInfo;
import com.generation.backend.dto.UserInfoDTO;
import com.generation.backend.dto.UtenteDTO;

@Service
public class AdditionalInfoService {

    private UAIMapper uaiMapper = UAIMapper.ISTANCE;

    public UtenteDTO toDTO(UserAdditionalInfo userAdditionalInfo) {
        return uaiMapper.toDTO(userAdditionalInfo);
    }

    public UserAdditionalInfo toEntity(FullCredentialDTO FullCredentialDTO) {
        return uaiMapper.toEntity(FullCredentialDTO);
    }

    // public UserInfoDTO toDTO(UserAdditionalInfo userAdditionalInfo) {
    //     UserInfoDTO res = new UserInfoDTO();
    //     res.setNome(userAdditionalInfo.getNome());
    //     res.setCognome(userAdditionalInfo.getCognome());
    //     res.setDob(userAdditionalInfo.getDob());
    //     return res;
    // }

    // public UserAdditionalInfo toEntity(FullCredentialDTO userAdditionalInfoDTO) {
    //     return mapper.toEntity(userAdditionalInfoDTO);
    // }

    // public UserAdditionalInfo toEntity(UtenteDTO utenteDTO) {
    //     return mapper.toEntity(utenteDTO);
    // }



}
