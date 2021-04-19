package wordcount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void testOnlyWord() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "word word";
        assertEquals(wordCounter.count(inputText), 2);
    }

    @Test
    public void testWhitespaceTypesInWord() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "word \t \n word";
        assertEquals(wordCounter.count(inputText), 2);
    }

    @Test
    public void testNotAllowedCharacterInWord() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "word wo5rd";
        assertEquals(wordCounter.count(inputText), 1);
    }

    @Test
    public void testSpecialCharacterInWord() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "word? wo$rd .word";
        assertEquals(wordCounter.count(inputText), 1);
    }

    @Test
    public void testConsecutiveSpacesInWord() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "word        word";
        assertEquals(wordCounter.count(inputText), 2);
    }

    @Test
    public void testUppercaseInWord() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "w OOoRD";
        assertEquals(wordCounter.count(inputText), 2);
    }

    @Test
    public void testSingleLetterWord() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "w word";
        assertEquals(wordCounter.count(inputText), 2);
    }

    @Test
    public void testExampleInput() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "Mary had a little lamb";
        assertEquals(wordCounter.count(inputText), 5);
    }

    @Test
    public void testExampleInputWithStopWords() {
        final IWordCounter wordCounter = new WordCounterStopWordsImpl("stopwords.txt");
        final String inputText = "Mary had a little lamb";
        assertEquals(wordCounter.count(inputText), 4);
    }

    @Test
    public void testUniqueWordsWithStopWords() {
        final IWordCounter wordCounter = new WordCounterStopWordsImpl("stopwords.txt");
        final String inputText = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        assertEquals(wordCounter.countUnique(inputText), 7);
    }
}
