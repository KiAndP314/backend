package com.generation.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.backend.auth.model.UserAdditionalInfo;
import com.generation.backend.auth.model.UserEntity;
import com.generation.backend.auth.repository.UserAdditionalInfoRepository;
import com.generation.backend.auth.repository.UserRepository;
import com.generation.backend.dto.UserInfoDTO;
import com.generation.backend.dto.UtenteDTO;
import com.generation.backend.exception.NotYourUserException;
import com.generation.backend.exception.UserNotFoundException;
import com.generation.backend.service.AdditionalInfoService;

@RestController
@RequestMapping("/UserAdditionalInfo")
public class UserAdditionalInfoController {

    // @Autowired
    // private UserRepository uRepo;

    @Autowired
    private UserAdditionalInfoRepository additionalInfoRepo;

    @Autowired
    private AdditionalInfoService additionalInfoService;

    @Autowired
    private UserAdditionalInfoRepository userAdditionalInfoRepo;

    @Autowired
    private UserRepository userRepo;
    
    @PostMapping("/{id}")
    public String insertUserInfo(@PathVariable Integer id, @RequestBody UserInfoDTO userInfo) {
        UserEntity ue = userRepo.findById(id).get();

        UserAdditionalInfo userAdditionalInfo = new UserAdditionalInfo();
        userAdditionalInfo.setNome(userInfo.getNome());
        userAdditionalInfo.setCognome(userInfo.getCognome());
        userAdditionalInfo.setDob(userInfo.getDob());
        userAdditionalInfo.setUser(ue);

        userAdditionalInfoRepo.save(userAdditionalInfo);
        
        return "User info registered";
    }

    @GetMapping("/{id}")
    public UtenteDTO getId(@PathVariable Integer id) { // era UserInfoDTO
        
            Optional<UserAdditionalInfo> res = additionalInfoRepo.findByUserId(id);
            // se non lo trova da una NoSuchElementException()
    
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = auth.getName();

            if (res.isEmpty())
                throw new UserNotFoundException("Utente con id: " + id + " non presente");

            if (!res.get().getUser().getEmail().equals(username)) {
                throw new NotYourUserException("Non tuo"); // apposita
            }

            return additionalInfoService.toDTO(res.get());
        
    }

    // prima della modifica
    // @GetMapping("/{id}")
    // public UserInfoDTO getId(@PathVariable Integer id) {
        
    //         Optional<UserAdditionalInfo> res = additionalInfoRepo.findByUserId(id);
    //         // se non lo trova da una NoSuchElementException()
    
    //         if (res.isEmpty())
    //             throw new UserNotFoundException("Utente con id: " + id + " non presente");

    //         return additionalInfoService.toDTO(res.get());
        
    // }

    //NullPointerException
    // @GetMapping("/{id}")
    // public UserInfoDTO getId(@PathVariable Integer id) {
    //     try {
    //         UserAdditionalInfo res = additionalInfoRepo.findByUserId(id);
    //         // se non lo trova da una NoSuchElementException()
    
    //         return additionalInfoService.toDTO(res);
    //     } catch(NullPointerException e) {
    //         System.out.println(e);
    //         throw new UserNotFoundException("Utente con id: " + id + " non presente");
    //     }
        
    // }
    

    // @GetMapping("/{id}")
    // public UserInfoDTO getId(@PathVariable Integer id) {

    //     UserAdditionalInfo res = additionalInfoRepo.findByUserId(id);
    //     // se non lo trova da una NoSuchElementException()

    //     return additionalInfoService.toDTO(res);
    // }

    
}
