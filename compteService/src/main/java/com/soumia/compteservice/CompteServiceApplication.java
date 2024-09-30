package com.soumia.compteservice;

import com.soumia.compteservice.entities.Compte;
import com.soumia.compteservice.enums.TypeCompte;
import com.soumia.compteservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CompteServiceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CompteServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository){
		return args -> {
			compteRepository.save(new Compte(null,98000, new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(null,12000, new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null,2100, new Date(), TypeCompte.COURANT));
			compteRepository.findAll().forEach(cp ->{
				System.out.println(cp.getType());
				System.out.println(cp.getSolde());
			});
		};
	}
}
