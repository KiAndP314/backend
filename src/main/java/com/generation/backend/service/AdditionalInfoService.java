package com.generation.backend.service;

import org.springframework.stereotype.Service;

import com.generation.backend.auth.model.UserAdditionalInfo;
import com.generation.backend.dto.UserInfoDTO;

@Service
public class AdditionalInfoService {

    public UserInfoDTO toDTO(UserAdditionalInfo userAdditionalInfo) {
        UserInfoDTO res = new UserInfoDTO();
        res.setNome(userAdditionalInfo.getNome());
        res.setCognome(userAdditionalInfo.getCognome());
        res.setDob(userAdditionalInfo.getDob());
        return res;
    }

}
