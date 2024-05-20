package com.itsmenicky.bibliotecaAcademica.repositories;

import com.itsmenicky.bibliotecaAcademica.models.Periodico;
import org.springframework.data.repository.CrudRepository;

public interface PeriodicoRepository extends CrudRepository<Periodico, String> {
    Periodico findById(long id);
}
