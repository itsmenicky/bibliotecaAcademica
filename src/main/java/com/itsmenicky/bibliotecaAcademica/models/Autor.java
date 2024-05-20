package com.itsmenicky.bibliotecaAcademica.models;

import lombok.Getter;
import java.util.List;
import jakarta.persistence.*;
import lombok.Setter;
import jakarta.validation.constraints.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Autor implements Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String nome;

    @ManyToMany
    private List<Livro> livros;
}
