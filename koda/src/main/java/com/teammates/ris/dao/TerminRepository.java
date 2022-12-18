package com.teammates.ris.dao;

import com.teammates.ris.models.Termin;
import com.teammates.ris.models.Uporabnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TerminRepository extends CrudRepository<Termin, Long> {
    @Query("SELECT t FROM Termin t, Aktivnost a WHERE t.aktivnost = a AND t.opis LIKE %?1% AND a.naziv LIKE ?2")
    List<Termin> vrniTerminPoOpisuInAktivnosti(String opis, String naziv);

    @Query("SELECT t FROM Termin t, Aktivnost a WHERE t.aktivnost = a AND t.zacetek LIKE ?1 AND a.naziv LIKE ?2")
    List<Termin> vrniTerminPoZacetkuInAktivnosti(String zacetek, String naziv);

    @Query("SELECT t FROM Termin t, Lokacija l, Aktivnost a WHERE t.aktivnost = a AND t.lokacija = l AND t.stevilo_mest > ?1 AND l.naslov LIKE ?2% AND a.naziv LIKE ?3%")
    List<Termin> vrniTerminPoSteviluMestInNaslovuInAktivnosti(int stevilo_mest, String naslov, String aktivnost);

    @Query("SELECT t FROM Termin t, Lokacija l, Aktivnost a WHERE t.aktivnost = a AND t.lokacija = l AND t.stevilo_mest > ?1 AND l.regija LIKE ?2% AND a.naziv LIKE ?3%")
    List<Termin> vrniTerminPoSteviluMestInRegijiInAktivnosti(int stevilo_mest, String regija, String aktivnost);

}
