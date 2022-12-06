package com.teammates.ris.controllers;


import com.teammates.ris.dao.AktivnostRepository;
import com.teammates.ris.dao.LokacijaRepository;
import com.teammates.ris.dao.TerminRepository;
import com.teammates.ris.exceptions.ResourceNotFoundException;
import com.teammates.ris.models.Aktivnost;
import com.teammates.ris.models.Termin;
import com.teammates.ris.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/termini")
public class TerminController {

    @Autowired
    private TerminRepository terminDao;

    @Autowired
    private AktivnostRepository aktivnostDao;

    @GetMapping
    public Iterable<Termin> vrniTermine(){
        return terminDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Termin> vrniAktivnost(@PathVariable(name = "id") Long id){
        return terminDao.findById(id);
    }

    @PostMapping("/aktivnost/{id}")
    public Optional<Termin> dodajTermin(@PathVariable(name = "id") Long id, @RequestBody Termin termin){
        return aktivnostDao.findById(id).map(aktivnost -> {
            termin.setAktivnost(aktivnost);

            return  terminDao.save(termin);
        });
    }

    @DeleteMapping("/{id}")
    public void izbrisiTermin(@PathVariable(name = "id") Long id){
        terminDao.deleteById(id);
    }

    @PutMapping("/{id}")
    public Termin spremeniTermin(@PathVariable(name = "id") Long id, @RequestBody Termin termin){
        Termin posodobljenTermin = terminDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Termin z idjem: " + id + " ne obstaja."));

        posodobljenTermin.setOpis(termin.getOpis());
        posodobljenTermin.setZacetek(termin.getZacetek());
        posodobljenTermin.setStevilo_mest(termin.getStevilo_mest());

        return  terminDao.save(posodobljenTermin);
    }
}