package at.george;

import at.george.counter.TextSequenceCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextSequenceCounterTests {

    private final Counter textSequenceCounter = new TextSequenceCounter();

    @Test
    public void testSingleWord() {
        long count = textSequenceCounter.count("word");

        assertEquals(1, count);
    }

    @Test
    public void testMultipleWords() {
        long count = textSequenceCounter.count("word word");

        assertEquals(2, count);

        count = textSequenceCounter.count("word word word");

        assertEquals(3, count);
    }

    @Test
    public void testMultipleWordsWithSpaces() {
        long count = textSequenceCounter.count("word  word             word                           word");

        assertEquals(4, count);
    }

    @Test
    public void testMultipleWordsWithNumbersInBetween() {
        long count = textSequenceCounter.count("wo3d wo3d");

        assertEquals(0, count);
    }

    @Test
    public void testMultipleWordsWithSpecialCharactersAtTheEnd() {
        long count = textSequenceCounter.count("word, word. word? word");

        assertEquals(1, count);
    }

    @Test
    public void testMultipleWordsWithSpecialCharactersAtTheBeginning() {
        long count = textSequenceCounter.count(",word .word ?word word");

        assertEquals(1, count);
    }
}
