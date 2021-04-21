package counter;

import evaluator.WordEvaluator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    private WordEvaluator wordEvaluator;
    private WordCounter wordCounter;

    @BeforeEach
    void setUp() {
        wordEvaluator = new WordEvaluator();
        wordCounter = new WordCounter(wordEvaluator);
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
    public void testSentenceWithSpaceDelimiter() {
        assertEquals(4, wordCounter.countWords("i am a sentence"));
        assertEquals(0, wordCounter.countWords(" "));
        assertEquals(0, wordCounter.countWords(""));
    }

    @Test
    public void whenSentenceHasStopwordsThenTheyShouldBeDisregarded() {
        Set<String> stopwords = new HashSet<>();
        stopwords.add("the");
        stopwords.add("a");
        stopwords.add("on");
        stopwords.add("off");

        wordEvaluator = new WordEvaluator(stopwords);
        wordCounter = new WordCounter(wordEvaluator);


        assertEquals(5, wordCounter.countWords("The Mary had a little lamb"));

        stopwords.add("The");
        assertEquals(4, wordCounter.countWords("The Mary had a little lamb"));
    }
}