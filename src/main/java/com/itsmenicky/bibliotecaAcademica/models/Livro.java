package com.itsmenicky.bibliotecaAcademica.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Base64;

@Data
@Entity
public class Livro implements Serializable{
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String título;

    @NotNull
    private Long ISBN;

    @NotEmpty
    private String situacao;

    @NotEmpty
    private String edicao;

    @NotEmpty
    private String autor;

    @Lob
    private byte[] foto_livro;

    public String getImagemBase64(){
        return Base64.getEncoder().encodeToString(this.foto_livro);
    }
}
