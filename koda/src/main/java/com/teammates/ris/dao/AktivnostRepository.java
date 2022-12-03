package com.teammates.ris.dao;

import com.teammates.ris.models.Aktivnost;
import org.springframework.data.repository.CrudRepository;

public interface AktivnostRepository extends CrudRepository<Aktivnost, Long> {
}