package com.itsmenicky.bibliotecaAcademica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.itsmenicky.bibliotecaAcademica.models")
public class BibliotecaAcademicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaAcademicaApplication.class, args);
	}

}
