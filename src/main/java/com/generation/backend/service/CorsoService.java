package com.generation.backend.service;

import org.springframework.stereotype.Service;

import com.generation.backend.dto.CorsoDTO;
import com.generation.backend.dto.CorsoDescriptionDTO;
import com.generation.backend.dto.mapper.CorsoMapper;
import com.generation.backend.model.Corso;

@Service
public class CorsoService {

    private CorsoMapper mapper = CorsoMapper.INSTANCE;

    public CorsoDescriptionDTO toDescDTO(Corso corso) {
        return mapper.toCorsoDescriptionDTO(corso);
    }

    public CorsoDTO toDTO(Corso corso) {
        return mapper.toDTO(corso);
    }

}
