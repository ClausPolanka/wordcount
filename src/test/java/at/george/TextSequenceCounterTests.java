package at.george;

import at.george.counter.TextSequenceCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextSequenceCounterTests {

    private final Counter textSequenceCounter = new TextSequenceCounter();

    @Test
    public void testSingleWord() {
        String input = "word";
        long count = textSequenceCounter.count(input);
        long countUnique = textSequenceCounter.countUnique(input);

        assertEquals(1, count);
        assertEquals(1, countUnique);
    }

    @Test
    public void testSingleWordWithDashes() {
        String input = "word-word";
        long count = textSequenceCounter.count(input);
        long countUnique = textSequenceCounter.countUnique(input);

        assertEquals(2, count);
        assertEquals(1, countUnique);
    }

    @Test
    public void testMultipleWords() {
        String inputWithTwoWords = "word word";
        long count = textSequenceCounter.count(inputWithTwoWords);
        long countUnique = textSequenceCounter.countUnique(inputWithTwoWords);

        assertEquals(2, count);
        assertEquals(1, countUnique);

        String inputWithThreeWords = "word word word";
        count = textSequenceCounter.count(inputWithThreeWords);
        countUnique = textSequenceCounter.countUnique(inputWithThreeWords);

        assertEquals(3, count);
        assertEquals(1, countUnique);
    }

    @Test
    public void testMultipleWordsWithDashes() {
        String input = "word-word test word-word";
        long count = textSequenceCounter.count(input);
        long countUnique = textSequenceCounter.countUnique(input);

        assertEquals(5, count);
        assertEquals(2, countUnique);
    }

    @Test
    public void testMultipleWordsWithSpaces() {
        String input = "word  word             word                           word";
        long count = textSequenceCounter.count(input);
        long countUnique = textSequenceCounter.countUnique(input);

        assertEquals(4, count);
        assertEquals(1, countUnique);
    }

    @Test
    public void testMultipleWordsWithNumbersInBetween() {
        String input = "wo3d wo3d";
        long count = textSequenceCounter.count(input);
        long countUnique = textSequenceCounter.countUnique(input);

        assertEquals(0, count);
        assertEquals(0, countUnique);
    }

    @Test
    public void testMultipleWordsWithSpecialCharactersAtTheEnd() {
        String input = "word, word. word? word";
        long count = textSequenceCounter.count(input);
        long countUnique = textSequenceCounter.countUnique(input);

        assertEquals(2, count);
        assertEquals(1, countUnique);
    }

    @Test
    public void testMultipleWordsWithSpecialCharactersAtTheBeginning() {
        String input = ",word .word ?word word";
        long count = textSequenceCounter.count(input);
        long countUnique = textSequenceCounter.countUnique(input);

        assertEquals(1, count);
        assertEquals(1, countUnique);
    }
}
