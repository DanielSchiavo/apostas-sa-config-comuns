package com.apostassa.infra.util;

import com.apostassa.dominio.ValidacaoException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

public class Util {
    public static String pegarJsonCorpoDaRequisicao(HttpServletRequest req) throws IOException {
        BufferedReader reader = req.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        return requestBody.toString();
    }

    public static void validar(Object object) throws ValidacaoException {
        Set<ConstraintViolation<Object>> violations = Validation.buildDefaultValidatorFactory().getValidator().validate(object);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Object> violation : violations) {
                sb.append(violation.getMessage()).append("\n");
            }
            throw new ValidacaoException(sb.toString());
        }
    }
}