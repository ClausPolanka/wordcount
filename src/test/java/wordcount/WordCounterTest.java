package wordcount;

import org.junit.jupiter.api.Test;
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
}
