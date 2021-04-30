package wordcounter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterImplTest {

    @Test
    public void whenWordsFromInput_thenReturnWordsNumber() {
        List<String> words = WordCounterUtils.retrieveWordsFromUserInput("Mary had a little lamb");
        WordCounter wordCounter = new WordCounterImpl(words);

        assertEquals(5, wordCounter.computeTotalWordsNumber());
    }
}
