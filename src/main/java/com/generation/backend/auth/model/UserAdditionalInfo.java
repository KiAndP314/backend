package com.generation.backend.auth.model;

import java.util.ArrayList;
import java.util.List;

import com.generation.backend.model.Abbonamento;
import com.generation.backend.model.Palestra;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class UserAdditionalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cognome;
    private String dob;
    private Boolean certificato = false;

    @OneToMany(mappedBy = "user")
    private List<Abbonamento> abbonamenti = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "palestra_id")
    private Palestra palestra;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    // public void setUserEntity(UserEntity userEntity) {
    //     this.user = userEntity;
    // }
}
