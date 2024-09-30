package com.soumia.compteservice.web;

import com.soumia.compteservice.entities.Compte;
import com.soumia.compteservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompteRestController {

    private CompteRepository compteRepository;

    @Autowired
    public CompteRestController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @GetMapping(path="/comptes")
    public List<Compte> findAllComptes(){
        return compteRepository.findAll();
    }

    @GetMapping(path="/comptes/{id}")
    public Compte findCompteById(@PathVariable Long id){
        Optional<Compte> result = compteRepository.findById(id);
        Compte compte = null;
        if(result.isPresent()){
           compte = result.get();
        }else{
            throw new RuntimeException("Did not find employee id -" + id);
        }
       return compte;
    }

    @PostMapping (path="/comptes")
    public Compte saveCompte(@RequestBody Compte compte){
        compteRepository.save(compte);
        return compte;
    }

    @PutMapping  (path="/comptes/{code}")
    public Compte updateCompte(@PathVariable Long code,@RequestBody Compte compte){
       compte.setCode(code);
        return compteRepository.save(compte);
    }

    @DeleteMapping (path="/comptes/{code}")
    public void updateCompte(@PathVariable Long code){
        compteRepository.deleteById(code);
    }
}
