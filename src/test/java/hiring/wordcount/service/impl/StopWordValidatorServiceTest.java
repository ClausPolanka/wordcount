package hiring.wordcount.service.impl;

import hiring.wordcount.exception.ValidatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StopWordValidatorServiceTest extends BaseServiceTest {

    StopWordValidatorService service;

    @Test
    public void getFileNotFoundException() {
        service.setValidatorResource("asdf");
        assertThrows(ValidatorException.class, () -> service.validate("anyString"));
    }

    @Test
    public void getValidatorException() {
        assertThrows(ValidatorException.class, () -> service.validate("anyString"));
    }

    @Test
    public void invalidParameterException() {
        assertThrows(InvalidParameterException.class, () -> service.validate(null));
        assertThrows(InvalidParameterException.class, () -> service.validate(""));
    }

    @BeforeEach
    public void setUp() {
        service = new StopWordValidatorService();
    }

    @Test
    public void testInValid() {
        assertDoesNotThrow(
                () -> service.setValidatorResource(getClass().getClassLoader().getResource("stopwords.txt").getFile()));
        assertDoesNotThrow(() -> {
            final boolean invalidWord = service.validate("the");
            assertFalse(invalidWord);
        });
    }

    @Test
    public void testName() {
        super.getServiceName(service);
    }

    @Test
    public void testValid() {
        assertDoesNotThrow(
                () -> service.setValidatorResource(getClass().getClassLoader().getResource("stopwords.txt").getFile()));
        assertDoesNotThrow(() -> {
            final boolean invalidWord = service.validate("test");
            assertTrue(invalidWord);
        });
    }

    @Test
    public void testValidResource() {
        assertDoesNotThrow(
                () -> service.setValidatorResource(getClass().getClassLoader().getResource("stopwords.txt").getFile()));
    }

}