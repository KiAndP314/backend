package com.generation.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.backend.auth.dto.mapper.AbbonamentoMapper;
import com.generation.backend.auth.model.UserAdditionalInfo;
import com.generation.backend.auth.repository.UserAdditionalInfoRepository;
import com.generation.backend.dto.AbbonamentoDTO;
import com.generation.backend.dto.RequestAbbonamentoDTO;
import com.generation.backend.model.Abbonamento;
import com.generation.backend.model.Corso;
import com.generation.backend.repository.AbbonamentoRepository;
import com.generation.backend.repository.CorsoRepository;

@RestController
@RequestMapping("/abbonamento")
public class AbbonamentoController {

    @Autowired
    private AbbonamentoRepository abbonamentoRepository;

    @Autowired
    private UserAdditionalInfoRepository userRepo;

    @Autowired
    private CorsoRepository corsoRepo;


    @PostMapping
    public AbbonamentoDTO abbonamento(@RequestBody RequestAbbonamentoDTO requestAbbonamentoDTO) {

        Abbonamento res = new Abbonamento();

        UserAdditionalInfo user = userRepo.findById(requestAbbonamentoDTO.getUser_id()).get();
        Corso corso = corsoRepo.findById(requestAbbonamentoDTO.getCorso_id()).get();

        res.setUser(user);
        res.setCorso(corso);

        abbonamentoRepository.save(res);
        return AbbonamentoMapper.INSTANCE.toDTO(res);
    }
}
