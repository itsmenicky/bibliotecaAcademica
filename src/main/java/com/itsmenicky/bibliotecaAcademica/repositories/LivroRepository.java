package com.itsmenicky.bibliotecaAcademica.repositories;
import com.itsmenicky.bibliotecaAcademica.models.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, String> {
    Livro findById(long id);
}
