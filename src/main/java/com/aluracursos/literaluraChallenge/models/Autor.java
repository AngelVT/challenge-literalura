package com.aluracursos.literaluraChallenge.models;

import com.aluracursos.literaluraChallenge.models.dto.AutorFromResponse;
import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    Integer anoNacimiento;
    Integer anoMuerte;
    @OneToOne
    @JoinColumn(name = "libro_id", referencedColumnName = "id")
    Libro libro;

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
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "+-+-+-+-+-+-+-+-+-+-   *   -+-+-+-+-+-+-+-+-+-+\n" +
                "   " + nombre + "\n" +
                "       " + anoNacimiento + " - " + anoMuerte + "\n" +
                "+-+-+-+-+-+-+-+-+-+-   *   -+-+-+-+-+-+-+-+-+-+\n";
    }
}
