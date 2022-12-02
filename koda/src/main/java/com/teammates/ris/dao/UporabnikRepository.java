package com.teammates.ris.dao;

import com.teammates.ris.models.Uporabnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long> {
    @Query("SELECT u FROM Uporabnik u WHERE u.ime = ?1 AND u.priimek = ?2")
    List<Uporabnik> vrniPoImenuInPriimku(String ime, String priimek);

    @Query("SELECT u FROM Uporabnik u WHERE u.ime = ?1 AND u.priimek = ?2 AND u.email = ?3")
    List<Uporabnik> vrniPoImenuInPriimkuInEmailu(String ime, String priimek, String email);


}
