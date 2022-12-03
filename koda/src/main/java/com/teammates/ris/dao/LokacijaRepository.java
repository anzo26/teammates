package com.teammates.ris.dao;

import com.teammates.ris.models.Lokacija;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LokacijaRepository extends CrudRepository<Lokacija, Long> {
    @Query("SELECT l FROM Lokacija l WHERE l.posta = ?1 AND l.regija = ?2")
    List<Lokacija> vrniPoPostiInRegiji(int posta, String regija);

    @Query("SELECT l FROM Lokacija l WHERE l.posta = ?1 AND l.regija = ?2 AND l.naslov LIKE ?3%")
    List<Lokacija> vrniPoPostiInRegijiInNaslovu(int posta, String regija, String naslov);
}
