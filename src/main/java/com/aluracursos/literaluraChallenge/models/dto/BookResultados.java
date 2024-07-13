package com.aluracursos.literaluraChallenge.models.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookResultados(@JsonAlias("results") List<LibrosFromResponse> books) {
}
