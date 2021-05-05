package at.george;

import at.george.counter.TextSequenceCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialCharactersTests {

    private final Counter textSequenceCounter = new TextSequenceCounter();

    @Test
    public void testMultipleWordsWithSpaces() {
        long count = textSequenceCounter.count("word  word                                    word                                word");

        assertEquals(4, count);
    }

    @Test
    public void testSingleWordWithNumbersInBetween() {
        long count = textSequenceCounter.count("wo3d");

        assertEquals(0, count);
    }

    @Test
    public void testMultipleWordsWithSpecialCharactersInBetween() {
        long count = textSequenceCounter.count("word wo$rd");

        assertEquals(1, count);
    }

    @Test
    public void testMultipleWordsWithSpecialCharactersAtTheEnd() {
        long count = textSequenceCounter.count("word, word. word? word");

        assertEquals(1, count);
    }
}
