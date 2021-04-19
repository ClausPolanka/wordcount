package wordcount;

import org.junit.jupiter.api.Test;
import wordcount.impl.WordCounterAllowedDashImpl;
import wordcount.impl.WordCounterImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void testOnlyWord() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "word word";
        assertEquals(2, wordCounter.count(inputText));
    }

    @Test
    public void testWhitespaceTypesInWord() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "word \t \n word";
        assertEquals(2, wordCounter.count(inputText));
    }

    @Test
    public void testNotAllowedCharacterInWord() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "word wo5rd";
        assertEquals(1, wordCounter.count(inputText));
    }

    @Test
    public void testSpecialCharacterInWord() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "word? wo$rd .word";
        assertEquals(1, wordCounter.count(inputText));
    }

    @Test
    public void testConsecutiveSpacesInWord() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "word        word";
        assertEquals(2, wordCounter.count(inputText));
    }

    @Test
    public void testUppercaseInWord() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "w OOoRD";
        assertEquals(2, wordCounter.count(inputText));
    }

    @Test
    public void testSingleLetterWord() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "w word";
        assertEquals(2, wordCounter.count(inputText));
    }

    @Test
    public void testExampleInput() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "Mary had a little lamb";
        assertEquals(5, wordCounter.count(inputText));
    }

    @Test
    public void testAverageWordLength() {
        String inputText = new Main().readInput("src/test/resources/sometext.txt");
        final IWordCounter wordCounter = new WordCounterImpl();
        assertEquals(23, wordCounter.count(inputText));
        assertEquals(17, wordCounter.countUnique(inputText));
        assertEquals(4.83, wordCounter.averageLength(inputText));
    }
}
