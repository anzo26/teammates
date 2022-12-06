package com.teammates.ris.controllers;


import com.teammates.ris.dao.AktivnostRepository;
import com.teammates.ris.models.Aktivnost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/aktivnost")
public class AktivnostController {


    @Autowired
    private AktivnostRepository aktivnostDao;

    @GetMapping
    public Iterable<Aktivnost> vrniAktivnosti(){
        return aktivnostDao.findAll();
    }


}