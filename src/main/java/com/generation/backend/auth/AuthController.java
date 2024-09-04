package com.generation.backend.auth;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.backend.auth.dto.AuthResponseDto;
import com.generation.backend.auth.dto.CredentialsDto;
import com.generation.backend.auth.dto.FullCredentialDTO;
import com.generation.backend.auth.model.Role;
import com.generation.backend.auth.model.UserAdditionalInfo;
import com.generation.backend.auth.model.UserEntity;
import com.generation.backend.auth.repository.RoleRepository;
import com.generation.backend.auth.repository.UserAdditionalInfoRepository;
import com.generation.backend.auth.repository.UserRepository;
import com.generation.backend.auth.security.JWTGenerator;
import com.generation.backend.service.AdditionalInfoService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTGenerator jwtGenerator;
    @Autowired
    private UserAdditionalInfoRepository uAIRepo;
    @Autowired
    private AdditionalInfoService additionalInfoService;

    @PostMapping("login")
    public AuthResponseDto login(@RequestBody CredentialsDto loginDto)
    {
        Authentication user = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()));

        User userPrincipal = (User) user.getPrincipal();

        UserEntity u = userRepository.findByEmail(userPrincipal.getUsername()).get();

        String token = jwtGenerator.generateToken(user); // crea token

        return new AuthResponseDto(token, u.getId());
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody FullCredentialDTO registerDto) 
    {
        if (userRepository.existsByEmail(registerDto.getEmail())) 
        {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));

        Role roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));

        user = userRepository.save(user);

        UserAdditionalInfo uAI = additionalInfoService.toEntity(registerDto);

        uAI.setUser(user);
        uAIRepo.save(uAI);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}
