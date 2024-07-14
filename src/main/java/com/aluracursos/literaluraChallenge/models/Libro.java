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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Autor autor;

    public Libro() {}

    public Libro(LibrosFromResponse libroResultado, String idioma) {
        this.titulo = libroResultado.titulo();
        this.idioma = idioma;
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

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getDescargas() {
        return descargas;
    }

    public void setAutores(Autor autores) {
        this.autor = autores;
    }

    @Override
    public String toString() {
        return  "+-+-+-+-+-+-+-+-+-+-   *   -+-+-+-+-+-+-+-+-+-+\n" +
                "   Titulo: " + titulo + "\n" +
                "   Idioma: " + idioma + "\n" +
                "   Autor: " +
                autor.getNombre() + "\n" +
                "          " + autor.getAnoNacimiento() + " - " + autor.getAnoMuerte() + "\n" +
                "   Descargas: " + descargas + "\n" +
                "+-+-+-+-+-+-+-+-+-+-   *   -+-+-+-+-+-+-+-+-+-+\n" ;
    }
}