package com.itsmenicky.bibliotecaAcademica.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Getter
@Setter
public class Usuário {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;

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
