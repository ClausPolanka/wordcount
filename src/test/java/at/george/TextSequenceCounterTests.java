package at.george;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextSequenceCounterTests {

    private final TextSequenceCounter textSequenceCounter = new TextSequenceCounter();

    @Test
    public void testMultipleWordsWithSpaces() {
        long count = textSequenceCounter.process("word  word             word                           word");

        assertEquals(count, 4);
    }

    @Test
    public void testMultipleWordsWithSpecialCharactersInBetween() {
        long count = textSequenceCounter.process("wo3d wo3d");

        assertEquals(count, 0);
    }

    @Test
    public void testMultipleWordsWithSpecialCharactersAtTheEnd() {
        long count = textSequenceCounter.process("word, word. word? word");

        assertEquals(count, 1);
    }

    @Test
    public void testMultipleWordsWithSpecialCharactersAtTheBeginning() {
        long count = textSequenceCounter.process(",word .word ?word word");

        assertEquals(count, 1);
    }
}
