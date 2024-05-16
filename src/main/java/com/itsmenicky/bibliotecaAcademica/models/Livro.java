package com.itsmenicky.bibliotecaAcademica.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Livro implements Serializable{
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_livro;

    @NotEmpty
    private String título;

    @NotEmpty
    private Integer ISBN;

    @NotEmpty
    private String situacao;

    @NotEmpty
    private String edicao;

    @ManyToMany
    private List<Autor> autores;
}
