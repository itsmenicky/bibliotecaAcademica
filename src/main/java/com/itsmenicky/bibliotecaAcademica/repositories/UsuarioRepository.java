package com.itsmenicky.bibliotecaAcademica.repositories;
import com.itsmenicky.bibliotecaAcademica.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
    Usuario findById(long id);
}
