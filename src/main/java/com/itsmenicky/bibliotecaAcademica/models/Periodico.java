package com.itsmenicky.bibliotecaAcademica.models;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;
import java.io.Serializable;

@Entity
@Data
public class Periodico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String titulo;

    @ManyToOne
    private Editora editora;
}
