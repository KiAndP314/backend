package com.generation.backend.model;

import com.generation.backend.auth.model.UserAdditionalInfo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Abbonamento {
    //id, user_id, corso_id, palestra_id, data_transazione

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAdditionalInfo user;

    @OneToOne
    @JoinColumn(name = "palestra_id")
    private Palestra palestra;

    @ManyToOne
    @JoinColumn(name = "corso_id")
    private Corso corso;
}
