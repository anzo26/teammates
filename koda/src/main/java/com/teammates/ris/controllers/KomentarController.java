package com.teammates.ris.controllers;


import com.teammates.ris.dao.UporabnikRepository;
import com.teammates.ris.dao.KomentarRepository;
import com.teammates.ris.exceptions.ResourceNotFoundException;
import com.teammates.ris.models.Komentar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/komentar")
public class KomentarController {

    @Autowired
    private KomentarRepository komentarDao;
    @Autowired
    private UporabnikRepository uporabnikDao;

    @GetMapping
    public Iterable<Komentar> vrniKomentarje(){
        return komentarDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Komentar> vrniKomentar(@PathVariable(name = "id") Long id){
        return komentarDao.findById(id);
    }

    @PostMapping("/uporabnik/{id}")
    public Optional<Komentar> dodajKomentar(@RequestBody Komentar komentar, @PathVariable(name = "id") Long id){
        return uporabnikDao.findById(id).map(uporabnik -> {
            komentar.setUporabnik(uporabnik);
            return  komentarDao.save(komentar);
        });
    }

    @PutMapping("/{id}")
    public Komentar spremeniKomentar(@PathVariable(name = "id") Long id, @RequestBody Komentar komentar){
        Komentar posodobljenKomentar = komentarDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Komentar z idjem: " + id + " ne obstaja."));

        posodobljenKomentar.setKomentar(komentar.getKomentar());

        return  komentarDao.save(posodobljenKomentar);
    }
}
