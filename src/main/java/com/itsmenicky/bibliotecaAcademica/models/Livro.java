package com.itsmenicky.bibliotecaAcademica.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Livro implements Serializable{
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String título;

    @NotNull
    private Integer ISBN;

    @NotEmpty
    private String situacao;

    @NotEmpty
    private String edicao;

    @ManyToMany
    private List<Autor> autores;
}
