package koda.src.main.java.com.teammates.ris.controllers;


import com.teammates.ris.dao.UporabnikRepository;
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

    @GetMapping
    public Iterable<Uporabnik> vrniUporabnike(){

        return uporabnikDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Uporabnik> vrniUporabnika(@PathVariable(name = "id") Long id){
        return uporabnikDao.findById(id);
    }

    @PostMapping
    public Uporabnik dodajUporabnika(@RequestBody Uporabnik uporabnik){
        return uporabnikDao.save(uporabnik);
    }


    @DeleteMapping("/{id}")
    public void izbrisiUporabnika(@PathVariable(name = "id") Long id){
        uporabnikDao.deleteById(id);
    }


}
