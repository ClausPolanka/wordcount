package hiring.wordcount.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordValidatorServiceTest extends BaseServiceTest {

    WordValidatorService service;

    @BeforeEach
    public void setUp() {
        service = new WordValidatorService();
    }

    @Test
    public void testName() {
        super.getServiceName(service);
    }

    @Test
    public void testValidateNotValide() {
        String testString = "t3st";
        assertFalse(service.validate(testString));

        testString = "test.";
        assertFalse(service.validate(testString));

        testString = ".t3st";
        assertFalse(service.validate(testString));
    }

    @Test
    public void testValidateValide() {
        String testString = "test";
        assertTrue(service.validate(testString));
    }

}