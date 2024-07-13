package com.aluracursos.literaluraChallenge.models.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorFromResponse(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Integer anoNaciemiento,
        @JsonAlias("death_year") Integer anoMuerte
) {
}
