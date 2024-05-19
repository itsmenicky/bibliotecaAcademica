package com.itsmenicky.bibliotecaAcademica.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Usuario implements Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private Date data_nascimento;

    @NotEmpty
    private String papel;

    @OneToMany
    private List<Livro> livros;

    @OneToMany
    private List<Periodico> periodicos;
}
