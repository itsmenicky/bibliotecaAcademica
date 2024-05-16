package com.itsmenicky.bibliotecaAcademica.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class Periodico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_periodico;

    @NotEmpty
    private String titulo;

    @OneToMany
    private String editora;
}
