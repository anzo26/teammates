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
}
