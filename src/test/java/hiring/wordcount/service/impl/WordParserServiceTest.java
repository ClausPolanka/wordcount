package hiring.wordcount.service.impl;

import hiring.wordcount.exception.ValidatorNotFoundException;
import hiring.wordcount.service.ValidatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordParserServiceTest extends BaseServiceTest {
    private WordParserService service;

    @BeforeEach
    public void setUp() {
        service = new WordParserService();
    }

    @Test
    public void testGetWordAsListForNotValid() {
        ValidatorService validatorService = new ValidatorService() {
            @Override
            public String getServiceName() {
                return "MockValidatorService";
            }

            @Override
            public boolean validate(String input) {
                return false;
            }
        };
        assertNull(service.getValidatorService());
        service.setValidator(validatorService);
        assertNotNull(service.getValidatorService());

        assertDoesNotThrow(() -> {
            final List<String> word_word_word = service.getWordsAsList("word word word");
            assertNotNull(word_word_word);
            assertTrue(word_word_word.isEmpty());
        });
    }

    @Test
    public void testGetWordAsListForValid() {
        ValidatorService validatorService = new ValidatorService() {
            @Override
            public String getServiceName() {
                return "MockValidatorService";
            }

            @Override
            public boolean validate(String input) {
                return true;
            }
        };
        assertNull(service.getValidatorService());
        service.setValidator(validatorService);
        assertNotNull(service.getValidatorService());

        assertDoesNotThrow(() -> {
            final List<String> word_word_word = service.getWordsAsList("word word word");
            assertNotNull(word_word_word);
            assertFalse(word_word_word.isEmpty());
            assertEquals(3, word_word_word.size());
        });
    }

    @Test
    public void testGetWordAsListWithInvalidParameterException() {
        service.setValidator(new ValidatorService() {
            @Override
            public String getServiceName() {
                return null;
            }

            @Override
            public boolean validate(String input) {
                return false;
            }
        });
        assertThrows(InvalidParameterException.class, () -> service.getWordsAsList(null));
    }

    @Test
    public void testGetWordAsListWithValidatorNotFoundException() {
        assertThrows(ValidatorNotFoundException.class, () -> service.getWordsAsList("input"));
        assertThrows(ValidatorNotFoundException.class, () -> service.getWordsAsList(""));
        assertThrows(ValidatorNotFoundException.class, () -> service.getWordsAsList(null));
    }

    @Test
    public void testName() {
        super.getServiceName(service);
    }
}