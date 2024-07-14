package com.aluracursos.literaluraChallenge.models;

import com.aluracursos.literaluraChallenge.models.dto.AutorFromResponse;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    Integer anoNacimiento;
    Integer anoMuerte;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Libro> libros = new ArrayList<>();

    public Autor() {}

    public Autor(AutorFromResponse autorFromResponse) {
        this.nombre = autorFromResponse.nombre();
        this.anoNacimiento = autorFromResponse.anoNaciemiento();
        this.anoMuerte = autorFromResponse.anoMuerte();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getAnoNacimiento() {
        return anoNacimiento;
    }

    public Integer getAnoMuerte() {
        return anoMuerte;
    }

    public void setLibro(Libro libro) {
        this.libros.add(libro);
    }

    @Override
    public String toString() {
        return "+-+-+-+-+-+-+-+-+-+-   *   -+-+-+-+-+-+-+-+-+-+\n" +
                "   " + nombre + "\n" +
                "       " + anoNacimiento + " - " + anoMuerte + "\n" +
                "+-+-+-+-+-+-+-+-+-+-   *   -+-+-+-+-+-+-+-+-+-+\n";
    }
}
