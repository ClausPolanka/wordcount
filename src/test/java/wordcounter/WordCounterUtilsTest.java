package wordcounter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordCounterUtilsTest {

    @Test
    public void whenRetrieveWordsFromUserInput_thenReturnList() {
        List<String> words = WordCounterUtils.retrieveWordsFromUserInput("Mary had a little lamb");

        assertEquals(4, words.size());
        assertFalse(words.contains("a"));
    }

    @Test
    public void whenRetrieveWordsFromExternalResource_thenReturnList() {
        List<String> words = WordCounterUtils.retrieveWordsFromResource("mytext.txt");

        assertEquals(4, words.size());
        assertFalse(words.contains("a"));
    }

    @Test
    public void whenWordIsCountable_thenReturnBoolean() {
        assertTrue(WordCounterUtils.isCountable("yeey"));
        assertFalse(WordCounterUtils.isCountable("off"));
    }
}
