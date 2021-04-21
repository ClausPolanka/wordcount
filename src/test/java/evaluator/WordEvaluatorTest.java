package evaluator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordEvaluatorTest {

    private WordEvaluator evaluator;

    @BeforeEach
    void setUp() {
        evaluator = new WordEvaluator();
    }

    @Test
    public void whenWordIsNullEvaluateShouldReturnFalse() {
        assertFalse(evaluator.evaluate(null));
    }

    @Test
    public void whenWordIsEmptySpacesEvaluateShouldReturnFalse() {
        assertFalse(evaluator.evaluate("       "));
    }

    @Test
    public void whenWordDoesContainNumbersEvaluateShouldReturnFalse() {
        assertFalse(evaluator.evaluate("wor3d"));
        assertFalse(evaluator.evaluate("3word"));
        assertFalse(evaluator.evaluate("word3"));
    }

    @Test
    public void whenWordContainsOnlyCharactersEvaluateShouldReturnTrue() {
        assertTrue(evaluator.evaluate("word"));
        /*
         * word evaluator should evaluate words not sentences.
         * if you're passing a sentence....you're using it wrong
         */
        assertFalse(evaluator.evaluate("hello word"));
        assertFalse(evaluator.evaluate("hello       word"));
    }

    @Test
    public void whenWordIsAStopwordThenEvaluateShouldReturnFalse() {
        Set<String> stopwords = new HashSet<>();
        stopwords.add("the");

        evaluator = new WordEvaluator(stopwords);

        assertTrue(evaluator.evaluate("hello"));
        assertFalse(evaluator.evaluate("the"));
    }
}