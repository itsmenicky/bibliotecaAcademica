package com.itsmenicky.bibliotecaAcademica.models;

import lombok.Getter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Entity
public class livro implements Serializable{
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
    private List<autor> autores;
}
