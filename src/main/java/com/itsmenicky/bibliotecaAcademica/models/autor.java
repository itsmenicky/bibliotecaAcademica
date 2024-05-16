package com.itsmenicky.bibliotecaAcademica.models;

import lombok.Getter;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Entity
public class autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_autor;

    @NotEmpty
    private String nome;

    @ManyToMany
    private List<livro> livros;
}
