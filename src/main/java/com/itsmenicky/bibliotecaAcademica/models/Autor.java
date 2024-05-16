package com.itsmenicky.bibliotecaAcademica.models;

import lombok.Getter;
import java.util.List;
import jakarta.persistence.*;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_autor;

    @NotEmpty
    private String nome;

    @ManyToMany
    private List<Livro> livros;
}
