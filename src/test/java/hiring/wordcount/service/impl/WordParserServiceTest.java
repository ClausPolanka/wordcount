package hiring.wordcount.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordParserServiceTest extends BaseServiceTest {
    private WordParserService service;

    @BeforeEach
    public void setUp() {
        service = new WordParserService();
    }

    @Test
    public void testGetWordAsListForValid() {
        final List<String> word_word_word = service.getWordsAsList("word word word");
        assertNotNull(word_word_word);
        assertFalse(word_word_word.isEmpty());
        assertEquals(3, word_word_word.size());
    }

    @Test
    public void testGetWordAsListWithInvalidParameterException() {
        assertThrows(InvalidParameterException.class, () -> service.getWordsAsList(null));
    }

    @Test
    public void testName() {
        super.getServiceName(service);
    }
}