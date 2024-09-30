package com.soumia.compteservice.repositories;

import com.soumia.compteservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository  extends JpaRepository<Compte,Long> {
}
