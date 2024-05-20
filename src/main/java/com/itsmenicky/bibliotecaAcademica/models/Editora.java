package com.itsmenicky.bibliotecaAcademica.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;
import jakarta.validation.constraints.*;

@Entity
@Getter
@Setter
public class Editora implements Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String nome;

    @OneToMany
    private List<Periodico> periodicos;
}
