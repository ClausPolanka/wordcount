package at.george;

import at.george.counter.TextSequenceCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialCharactersTests {

    private final Counter textSequenceCounter = new TextSequenceCounter();

    @Test
    public void testMultipleWordsWithSpaces() {
        long count = textSequenceCounter.count("word  word                                    word                                word");

        assertEquals(count, 4);
    }

    @Test
    public void testSingleWordWithNumbersInBetween() {
        long count = textSequenceCounter.count("wo3d");

        assertEquals(count, 0);
    }

    @Test
    public void testMultipleWordsWithSpecialCharactersInBetween() {
        long count = textSequenceCounter.count("word wo$rd");

        assertEquals(count, 1);
    }

    @Test
    public void testMultipleWordsWithSpecialCharactersAtTheEnd() {
        long count = textSequenceCounter.count("word, word. word? word");

        assertEquals(count, 1);
    }
}
