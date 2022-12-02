package koda.src.main.java.com.teammates.ris.controllers;


import com.teammates.ris.dao.KomentarRepository;
import com.teammates.ris.models.Komentar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/komentar")
public class KomentarController {

    @Autowired
    private KomentarRepository komentarDao;

    @GetMapping
    public Iterable<Komentar> vrniKomentarje(){

        return komentarDao.findAll();
    }
}
