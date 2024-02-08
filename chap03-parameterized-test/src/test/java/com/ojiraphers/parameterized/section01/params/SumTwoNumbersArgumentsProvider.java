package com.ojiraphers.parameterized.section01.params;

import org.junit.jupiter.params.provider.ArgumentsProvider;

public class SumTwoNumbersArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {

        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(3, 4, 7),
                Arguments.of(10, 20, 30),
                Arguments.of(100, 500, 600),
                Arguments.of(123, 456, 579)
        );
    }
}
