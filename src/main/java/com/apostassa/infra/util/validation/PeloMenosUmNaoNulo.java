package com.apostassa.infra.util.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target( { TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PeloMenosUmNaoNulo.PeloMenosUmNaoNuloValidator.class)
@Documented
public @interface PeloMenosUmNaoNulo {

    String message() default "Pelo menos um campo deve ser enviado!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] fieldNames();


    public static class PeloMenosUmNaoNuloValidator implements ConstraintValidator<PeloMenosUmNaoNulo, Object> {

        private String[] fieldNames;
        private String messageKey;

        @Override
        public void initialize(PeloMenosUmNaoNulo validateDateRange) {
            this.fieldNames = validateDateRange.fieldNames();
            this.messageKey = validateDateRange.message();
        }

        @Override
        public boolean isValid(Object obj, ConstraintValidatorContext validatorContext) {
            try {
                if (fieldNames.length == 1 && fieldNames[0].equals("*")){
                    Field[] declaredFields = obj.getClass().getDeclaredFields();
                    for (Field field : declaredFields) {
                        field.setAccessible(true);
                        Object value = field.get(obj);
                        if (value != null) {
                            return true;
                        }
                    }
                } else {
                    for (String fieldName : fieldNames) {
                        Field field = obj.getClass().getDeclaredField(fieldName);
                        field.setAccessible(true);
                        Object value = field.get(obj);
                        if (value != null) {
                            return true;
                        }
                    }
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            validatorContext.buildConstraintViolationWithTemplate(messageKey)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();

            return false;
        }
    }
}