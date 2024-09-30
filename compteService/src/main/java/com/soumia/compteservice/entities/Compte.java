package com.soumia.compteservice.entities;

import com.soumia.compteservice.enums.TypeCompte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Compte {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private double solde;
    private Date dateCretation;

    @Enumerated(EnumType.STRING)
    private TypeCompte type;

}
