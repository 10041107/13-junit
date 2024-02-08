package com.ojiraphers.parameterized.section01.params;

import org.junit.jupiter.params.provider.ArgumentsProvider;

public class SlashyDateConverter implements ArgumentsProvider {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {

        if (!(source instanceof String)) {
            throw new IllegalArgumentException(
                    "The argument should be a string: " + source);
        }

        try {
            String[] parts = ((String) source).split("/");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);

            return LocalDate.of(year, month, day);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to convert", e);
        }

    }

}
