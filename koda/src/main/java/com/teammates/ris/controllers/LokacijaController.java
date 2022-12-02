package com.teammates.ris.controllers;


import com.teammates.ris.dao.LokacijaRepository;
import com.teammates.ris.exceptions.ResourceNotFoundException;
import com.teammates.ris.models.Lokacija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lokacije")
public class LokacijaController {

    @Autowired
    private LokacijaRepository lokacijaDao;

    @GetMapping
    public Iterable<Lokacija> vrniLokacije(){
        return lokacijaDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Lokacija> vrniLokacijo(@PathVariable(name = "id") Long id){
        return lokacijaDao.findById(id);
    }

    @GetMapping("/posta/{posta}/regija/{regija}")
    public Iterable<Lokacija> vrniPoPostiInRegiji(@PathVariable(name = "posta") int posta, @PathVariable(name = "regija") String regija){
        return lokacijaDao.vrniPoPostiInRegiji(posta, regija);
    }

    @PostMapping
    public Lokacija dodajLokacijo(@RequestBody Lokacija lokacija){
        return lokacijaDao.save(lokacija);
    }

    @DeleteMapping("/{id}")
    public void izbrisiLokacijo(@PathVariable(name = "id") Long id){
        lokacijaDao.deleteById(id);
    }

    @PutMapping("/{id}") //spreminjanje lokacije
    public Lokacija spremeniLokacijo(@PathVariable(name = "id") Long id, @RequestBody Lokacija lokacija){
        Lokacija posodobljenaLokacija = lokacijaDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lokacija ne obstaja z id: " + id));

        posodobljenaLokacija.setRegija(lokacija.getRegija());
        posodobljenaLokacija.setNaslov(lokacija.getNaslov());

        return  lokacijaDao.save(posodobljenaLokacija);
    }

}
