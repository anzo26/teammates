package com.teammates.ris.dao;

import com.teammates.ris.models.Uporabnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long> {
    @Query("SELECT u FROM Uporabnik u WHERE u.ime = ?1 AND u.priimek = ?2")
    List<Uporabnik> vrniPoImenuInPriimku(String ime, String priimek);

    @Query("SELECT u FROM Uporabnik u WHERE u.ime LIKE ?1% AND u.priimek LIKE ?2% AND u.email LIKE ?3%")
    List<Uporabnik> vrniPoImenuInPriimkuInEmailu(String ime, String priimek, String email);

    @Query("SELECT u FROM Uporabnik u WHERE u.ime LIKE ?1% AND u.priimek LIKE ?2% AND u.uporabnisko_ime LIKE ?3%")
    List<Uporabnik> vrniPoImenuInPriimkuInUporabniskemImenu(String ime, String priimek, String uporabnisko_ime);

    @Query("SELECT u FROM Uporabnik u, Komentar k WHERE k.uporabnik = u AND u.ime LIKE ?1 AND u.priimek LIKE ?2 AND k.komentar LIKE %?3%")
    List<Uporabnik> vrniPoImenuInPriimkuInKomentarju(String ime, String priimek, String komentar);

    @Query("SELECT u FROM Uporabnik u, Lokacija l WHERE u.lokacija = l AND u.ime LIKE ?1% AND u.priimek LIKE ?2% AND l.naslov LIKE ?3%")
    List<Uporabnik> vrniPoImenuInPriimkuInNaslovu(String ime, String priimek, String naslov);

}
