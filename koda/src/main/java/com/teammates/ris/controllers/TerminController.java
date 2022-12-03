package com.teammates.ris.controllers;


import com.teammates.ris.dao.TerminRepository;
import com.teammates.ris.models.Termin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/termini")
public class TerminController {

    @Autowired
    private TerminRepository terminDao;

    @GetMapping
    public Iterable<Termin> vrniTermine(){
        return terminDao.findAll();
    }
}