package com.teammates.ris.controllers;


import com.teammates.ris.dao.TerminRepository;
import com.teammates.ris.dao.UporabnikRepository;
import com.teammates.ris.dao.KomentarRepository;
import com.teammates.ris.exceptions.ResourceNotFoundException;
import com.teammates.ris.models.Komentar;
import com.teammates.ris.models.Termin;
import com.teammates.ris.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/komentar")
public class KomentarController {

    @Autowired
    private KomentarRepository komentarDao;

    @Autowired
    private UporabnikRepository uporabnikDao;

    @Autowired
    private TerminRepository terminDao;

    @GetMapping
    public Iterable<Komentar> vrniKomentarje(){
        return komentarDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Komentar> vrniKomentar(@PathVariable(name = "id") Long id){
        return komentarDao.findById(id);
    }

    @PostMapping("/uporabnik/{id_uporabnik}/termin/{id_termin}")
    public Komentar dodajKomentar(@RequestBody Komentar komentar, @PathVariable(name = "id_uporabnik") Long id_uporabnik, @PathVariable(name = "id_termin") Long id_termin){
        Optional<Uporabnik> u = uporabnikDao.findById(id_uporabnik);
        Optional<Termin> t = terminDao.findById(id_termin);
        if(u.isPresent() && t.isPresent()){
            komentar.setUporabnik(u.get());
            komentar.setTermin(t.get());
        }
        return komentarDao.save(komentar);
    }

    @PutMapping("/{id}")
    public Komentar spremeniKomentar(@PathVariable(name = "id") Long id, @RequestBody Komentar komentar){
        Komentar posodobljenKomentar = komentarDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Komentar z idjem: " + id + " ne obstaja."));

        posodobljenKomentar.setKomentar(komentar.getKomentar());

        return  komentarDao.save(posodobljenKomentar);
    }

    @DeleteMapping("/{id}")
    public void izbrisiKomentar(@PathVariable(name = "id") Long id){
        komentarDao.deleteById(id);
    }
}
