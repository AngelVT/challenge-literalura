package com.aluracursos.literaluraChallenge.models;

import com.aluracursos.literaluraChallenge.models.dto.LibrosFromResponse;
import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String titulo;
    String idioma;
    Double descargas;
    @OneToOne(mappedBy = "libro", cascade = CascadeType.ALL)
    Autor autores;

    public Libro() {}

    public Libro(LibrosFromResponse libroResultado) {
        this.titulo = libroResultado.titulo();
        this.idioma = libroResultado.idiomas().get(0);
        this.descargas = Double.valueOf(libroResultado.descargas());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public Double getDescargas() {
        return descargas;
    }

    public void setAutores(Autor autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return  "+-+-+-+-+-+-+-+-+-+-   *   -+-+-+-+-+-+-+-+-+-+\n" +
                "   Titulo: " + titulo + "\n" +
                "   Idioma: " + idioma + "\n" +
                "   Autor: " +
                autores.getNombre() + "\n" +
                "          " + autores.getAnoNacimiento() + " - " + autores.getAnoMuerte() + "\n" +
                "   Descargas: " + descargas + "\n" +
                "+-+-+-+-+-+-+-+-+-+-   *   -+-+-+-+-+-+-+-+-+-+\n" ;
    }
}