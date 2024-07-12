package com.aluracursos.literaluraChallenge.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONToClass implements IDataParser {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T parseTo(String json, Class<T> clas) {
        try {
            return objectMapper.readValue(json, clas);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
