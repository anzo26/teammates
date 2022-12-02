package koda.src.main.java.com.teammates.ris.controllers;


import com.teammates.ris.dao.LokacijaRepository;
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

    @PostMapping
    public Lokacija dodajLokacijo(@RequestBody Lokacija lokacija){
        return lokacijaDao.save(lokacija);
    }

    @DeleteMapping("/{id}")
    public void izbrisiLokacijo(@PathVariable(name = "id") Long id){
        lokacijaDao.deleteById(id);
    }



}
