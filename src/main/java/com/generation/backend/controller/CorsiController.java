package com.generation.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.backend.dto.CorsoDTO;
import com.generation.backend.dto.CorsoDescriptionDTO;
import com.generation.backend.exception.CorsoNotFoundException;
import com.generation.backend.model.Corso;
import com.generation.backend.repository.CorsoRepository;
import com.generation.backend.service.CorsoService;

@RestController
@RequestMapping("/corsi")
public class CorsiController {

    @Autowired
    private CorsoRepository corsoRepository;

    @Autowired
    private CorsoService corsoService;

    @GetMapping
    public List<CorsoDescriptionDTO> getCorsi() {

        List<Corso> corsi = corsoRepository.findAll();
        List<CorsoDescriptionDTO> res = new ArrayList<>();

        for (Corso c : corsi) {
            CorsoDescriptionDTO cDTO = corsoService.toDescDTO(c);
            res.add(cDTO);
        }

        return res;
    }

    @GetMapping("/{id}")
    public CorsoDTO getCorso(@PathVariable Integer id) {
        Optional<Corso> corso = corsoRepository.findById(id);

        if(corso.isEmpty()) {
            throw new CorsoNotFoundException("Corso non trovato");
        }

        CorsoDTO res = corsoService.toDTO(corso.get());

        return res;
    }

}
