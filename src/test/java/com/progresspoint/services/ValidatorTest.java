package com.progresspoint.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    private Validator validator;

    @Test
    void getFileExtension_wrongExtnsionGiven_expectCorrectExtension() {
        // Given
        validator = new Validator("src/main/resources/picFakePdf.pdf",
                "src/main/resources/supported.csv");
        // When
        String expectedExtension = "jpg";
        String resultExtension = validator.getFileExtension();

        // Then
        assertEquals(expectedExtension, resultExtension);
    }

    @Test
    void getFileExtension_correctExtensionGiven_expectCorrectExtension() {
        // Given
        validator = new Validator("src/main/resources/pic1.jpg",
                "src/main/resources/supported.csv");
        // When
        String expectedExtension = "jpg";
        String resultExtension = validator.getFileExtension();

        // Then
        assertEquals(expectedExtension, resultExtension);
    }

    @Test
    void getFileExtension_wrongFileFormat_expectException() {
        // Given
        validator = new Validator("src/main/resources/pngDocument.png",
                "src/main/resources/supported.csv");
        // Then
        assertThrows(RuntimeException.class, () -> validator.getFileExtension());
    }


}