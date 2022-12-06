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
}
