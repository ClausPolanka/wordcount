package counter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    private WordCounter wordCounter;

    @BeforeEach
    void setUp() {
        wordCounter = new WordCounter();
    }

    @Test
    public void whenSentenceIsNullThenWordCountIsZero() {
        assertEquals(0, wordCounter.countWords(null));
    }

    @Test
    public void whenSentenceIsEmptyThenWordCountIsZero() {
        assertEquals(0, wordCounter.countWords(""));
    }

    @Test
    public void whenDelimiterIsNullThenWordCountIsZero() {
        assertEquals(3, wordCounter.countWords("im a sentence"));
    }
}