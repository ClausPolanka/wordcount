package wordcounter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterUtilsTest {
    @Test
    public void whenRetrieveWordsFromUserInput_thenReturnList() {
        List<String> words = WordCounterUtils.retrieveWordsFromUserInput("Mary had a little lamb");

        assertEquals(5, words.size());
    }
}
