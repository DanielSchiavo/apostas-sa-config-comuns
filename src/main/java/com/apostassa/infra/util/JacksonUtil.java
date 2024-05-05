package com.apostassa.infra.util;

import com.apostassa.dominio.ValidacaoException;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDateTime;

public abstract class JacksonUtil {

    private static final String mensagemJsonProcessingException = "Erro ao processar objeto para JSON";

    private static ObjectMapper configureObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configOverride(LocalDateTime.class).setFormat(JsonFormat.Value.forPattern("dd/MM/yyyy hh:MM:ss"));
        return objectMapper;
    }

    public static String serializador(Object objeto) {
        try {
            ObjectMapper objectMapper = configureObjectMapper();
            return objectMapper.writeValueAsString(objeto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(mensagemJsonProcessingException);
        }
    }

    public static String serializadorNotNull(Object objeto) {
        try {
            ObjectMapper objectMapper = configureObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return objectMapper.writeValueAsString(objeto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(mensagemJsonProcessingException);
        }
    }

    public static String serializadorNotEmpty(Object objeto) {
        try {
            ObjectMapper objectMapper = configureObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
            return objectMapper.writeValueAsString(objeto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(mensagemJsonProcessingException);
        }
    }

    public static String serializadorNotNullAndNotEmpty(Object objeto) {
        try {
            ObjectMapper objectMapper = configureObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            objectMapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
            return objectMapper.writeValueAsString(objeto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(mensagemJsonProcessingException);
        }
    }

    public static Object deserializar(String json, Class<?> clazz) throws ValidacaoException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            return objectMapper.readValue(json, clazz);
        } catch (JsonMappingException e) {
            throw new ValidacaoException("Erro ao mapear json");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ValidacaoException(mensagemJsonProcessingException);
        }
    }
}
