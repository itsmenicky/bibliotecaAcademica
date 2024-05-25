package com.itsmenicky.bibliotecaAcademica.models;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Base64;
import java.util.Date;

@Entity
@Data
public class Periodico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String titulo;

    @NotEmpty
    private String data_publicacao;

    @Lob
    private byte[] capa_periodico;

    public String getImagemBase64(){
        return Base64.getEncoder().encodeToString(this.capa_periodico);
    }
}
