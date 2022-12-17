package com.teammates.ris.controllers;


import com.teammates.ris.dao.AktivnostRepository;
import com.teammates.ris.exceptions.ResourceNotFoundException;
import com.teammates.ris.models.Aktivnost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/aktivnost")
public class AktivnostController {


    @Autowired
    private AktivnostRepository aktivnostDao;

    @GetMapping
    public Iterable<Aktivnost> vrniAktivnosti(){
        return aktivnostDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Aktivnost> vrniAktivnost(@PathVariable(name = "id") Long id){
        return aktivnostDao.findById(id);
    }

    @PostMapping
    public Aktivnost dodajAktivnost(@RequestBody Aktivnost aktivnost){
        return aktivnostDao.save(aktivnost);
    }

    @PutMapping("/{id}")
    public Aktivnost spremeniAktivnost(@PathVariable(name = "id") Long id, @RequestBody Aktivnost aktivnost){
        Aktivnost posodobljenaAktivnost = aktivnostDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aktivnost z idjem: " + id + " ne obstaja."));

        posodobljenaAktivnost.setNaziv(aktivnost.getNaziv());
        posodobljenaAktivnost.setOpis(aktivnost.getOpis());

        return  aktivnostDao.save(posodobljenaAktivnost);
    }

    @DeleteMapping("/{id}")
    public void izbrisiAktivnost(@PathVariable(name = "id") Long id){
        aktivnostDao.deleteById(id);
    }

}