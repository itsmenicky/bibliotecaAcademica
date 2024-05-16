package com.itsmenicky.bibliotecaAcademica.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_editora;

    @NotEmpty
    private String nome;

    @OneToMany
    private List<Periodico> periodicos;
}
