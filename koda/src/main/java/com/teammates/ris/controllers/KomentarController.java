package com.teammates.ris.controllers;


import com.teammates.ris.dao.KomentarRepository;
import com.teammates.ris.models.Komentar;
import com.teammates.ris.models.Lokacija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/komentar")
public class KomentarController {

    @Autowired
    private KomentarRepository komentarDao;

    @GetMapping
    public Iterable<Komentar> vrniKomentarje(){
        return komentarDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Komentar> vrniKomentar(@PathVariable(name = "id") Long id){
        return komentarDao.findById(id);
    }

    @PostMapping
    public Komentar dodajKomentar(@RequestBody Komentar komentar){
        return komentarDao.save(komentar);
    }

    @DeleteMapping("/{id}")
    public void izbrisiKomentar(@PathVariable(name = "id") Long id){
        komentarDao.deleteById(id);
    }

}
