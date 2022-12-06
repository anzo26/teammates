package com.teammates.ris.controllers;


import com.teammates.ris.dao.LokacijaRepository;
import com.teammates.ris.dao.UporabnikRepository;
import com.teammates.ris.exceptions.ResourceNotFoundException;
import com.teammates.ris.models.Lokacija;
import com.teammates.ris.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/uporabniki")
public class UporabnikController {

    @Autowired
    private UporabnikRepository uporabnikDao;

    @Autowired
    private LokacijaRepository lokacijaDao;


    @GetMapping
    public Iterable<Uporabnik> vrniUporabnike(){

        return uporabnikDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Uporabnik> vrniUporabnika(@PathVariable(name = "id") Long id){
        return uporabnikDao.findById(id);
    }

    @GetMapping("/ime/{ime}/priimek/{priimek}")
    public Iterable<Uporabnik> vrniPoImenuInPriimku(@PathVariable(name = "ime") String ime, @PathVariable(name = "priimek") String priimek){
        return uporabnikDao.vrniPoImenuInPriimku(ime, priimek);
    }



    @GetMapping("/ime/{ime}/priimek/{priimek}/email/{email}")
    public Iterable<Uporabnik> vrniPoImenuInPriimkuInEmailu(@PathVariable(name = "ime") String ime, @PathVariable(name = "priimek") String priimek, @PathVariable(name = "email") String email){
        return uporabnikDao.vrniPoImenuInPriimkuInEmailu(ime, priimek, email);
    }

    @GetMapping("/ime/{ime}/priimek/{priimek}/uporabnisko_ime/{uporabnisko_ime}")
    public Iterable<Uporabnik> vrniPoImenuInPriimkuInUporabniskemImenu(@PathVariable(name = "ime") String ime, @PathVariable(name = "priimek") String priimek, @PathVariable(name = "uporabnisko_ime") String uporabnisko_ime){
        return uporabnikDao.vrniPoImenuInPriimkuInUporabniskemImenu(ime, priimek, uporabnisko_ime);
    }

    @GetMapping("/ime/{ime}/priimek/{priimek}/komentar/{komentar}")
    public Iterable<Uporabnik> vrniPoImenuInPriimkuInKomentarju(@PathVariable(name = "ime") String ime, @PathVariable(name = "priimek") String priimek, @PathVariable(name = "komentar") String komentar){
        return uporabnikDao.vrniPoImenuInPriimkuInKomentarju(ime, priimek, komentar);
    }

    @GetMapping("/ime/{ime}/priimek/{priimek}/naslov/{naslov}")
    public Iterable<Uporabnik> vrniPoImenuInPriimkuInNaslovu(@PathVariable(name = "ime") String ime, @PathVariable(name = "priimek") String priimek, @PathVariable(name = "naslov") String naslov){
        return uporabnikDao.vrniPoImenuInPriimkuInNaslovu(ime, priimek, naslov);
    }

    //dodajanje uporabnika z lokacijo
    @PostMapping("/lokacija/{id}")
    public Optional<Uporabnik> dodajUporabnika(@PathVariable(name = "id") Long id, @RequestBody Uporabnik uporabnik){
        return lokacijaDao.findById(id).map(lokacija -> {
            uporabnik.setLokacija(lokacija);

            return  uporabnikDao.save(uporabnik);
        });
    }


    @DeleteMapping("/{id}")
    public void izbrisiUporabnika(@PathVariable(name = "id") Long id){
        uporabnikDao.deleteById(id);
    }

    @PutMapping("/{id}")
    public Uporabnik spremeniUporabnika(@PathVariable(name = "id") Long id, @RequestBody Uporabnik uporabnik){
        Uporabnik posodobljenUporabnik = uporabnikDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Uporabnik ne obstaja z id: " + id));

        posodobljenUporabnik.setAdmin(uporabnik.isAdmin());
        posodobljenUporabnik.setIme(uporabnik.getIme());
        posodobljenUporabnik.setPriimek(uporabnik.getPriimek());
        posodobljenUporabnik.setEmail(uporabnik.getEmail());
        posodobljenUporabnik.setUporabnisko_ime(uporabnik.getUporabnisko_ime());
        posodobljenUporabnik.setGeslo(uporabnik.getGeslo());

        return  uporabnikDao.save(posodobljenUporabnik);
    }





}
