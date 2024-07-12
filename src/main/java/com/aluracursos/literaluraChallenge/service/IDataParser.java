package com.aluracursos.literaluraChallenge.service;

public interface IDataParser {
    <T> T parseTo(String json, Class<T> clas);
}
