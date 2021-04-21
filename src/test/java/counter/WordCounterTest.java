package counter;

import evaluator.Evaluator;
import evaluator.WordEvaluator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    private Evaluator wordEvaluator;
    private WordCounter wordCounter;

    @BeforeEach
    void setUp() {
        wordEvaluator = new WordEvaluator();
        wordCounter = new WordCounter(wordEvaluator);
    }

    @Test
    public void whenSentenceIsNullThenWordCountIsZero() {
        assertEquals(0, wordCounter.countWords(null, " "));
    }

    @Test
    public void whenDelimiterIsNullThenWordCountIsZero() {
        assertEquals(0, wordCounter.countWords("im a sentence", null));
    }

    @Test
    public void whenSentenceAndDelimiterAreNullThenWordCountIsZero() {
        assertEquals(0, wordCounter.countWords(null, null));
    }

    @Test
    public void testSentenceWithSpaceDelimiter() {
        assertEquals(4, wordCounter.countWords("i am a sentence", " "));
        assertEquals(0, wordCounter.countWords(" ", " "));
        assertEquals(0, wordCounter.countWords("", " "));
    }
}