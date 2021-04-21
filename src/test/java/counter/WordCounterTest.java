package counter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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
    public void whenDelimiterIsNullThenWordCountIsZero() {
        assertEquals(0, wordCounter.countWords("im a sentence"));
    }

    @Test
    public void whenSentenceAndDelimiterAreNullThenWordCountIsZero() {
        assertEquals(0, wordCounter.countWords(null));
    }

    @Test
    public void whenSentenceHasStopwordsThenTheyShouldBeDisregarded() {
        Set<String> stopwords = new HashSet<>();
        stopwords.add("the");
        stopwords.add("a");
        stopwords.add("on");
        stopwords.add("off");

        wordCounter = new WordCounter();


        assertEquals(5, wordCounter.countWords("The Mary had a little lamb"));

        stopwords.add("The");
        assertEquals(4, wordCounter.countWords("The Mary had a little lamb"));
    }
}