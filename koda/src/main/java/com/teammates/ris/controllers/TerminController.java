package com.teammates.ris.controllers;


import com.teammates.ris.dao.AktivnostRepository;
import com.teammates.ris.dao.LokacijaRepository;
import com.teammates.ris.dao.TerminRepository;
import com.teammates.ris.exceptions.ResourceNotFoundException;
import com.teammates.ris.models.Aktivnost;
import com.teammates.ris.models.Lokacija;
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
    private LokacijaRepository lokacijaDao;

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

    @GetMapping("/opis/{opis}/aktivnost/{naziv}")
    public Iterable<Termin> vrniTerminPoSteviluIgralcevInAktivnosti(@PathVariable(name = "opis") String opis, @PathVariable(name = "naziv") String naziv){
        return terminDao.vrniTerminPoSteviluIgralcevInAktivnosti(opis, naziv);
    }

    @GetMapping("/zacetek/{zacetek}/aktivnost/{naziv}")
    public Iterable<Termin> vrniTerminPoZacetkuInAktivnosti(@PathVariable(name = "zacetek") String zacetek, @PathVariable(name = "naziv") String naziv){
        return terminDao.vrniTerminPoZacetkuInAktivnosti(zacetek, naziv);
    }


    @PostMapping("/lokacija/{id_lokacija}/aktivnost/{id_aktivnost}")
    public Termin dodajTermin(@RequestBody Termin termin, @PathVariable(name = "id_lokacija") Long id_lokacija, @PathVariable(name = "id_aktivnost") Long id_aktivnost){
        Optional<Lokacija> l = lokacijaDao.findById(id_lokacija);
        Optional<Aktivnost> a = aktivnostDao.findById(id_aktivnost);
        if(l.isPresent() && a.isPresent()){
            termin.setLokacija(l.get());
            termin.setAktivnost(a.get());
        }
        return terminDao.save(termin);
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