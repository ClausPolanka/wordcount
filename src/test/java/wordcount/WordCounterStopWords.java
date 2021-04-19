package wordcount;

import org.junit.jupiter.api.Test;
import wordcount.impl.WordCounterStopWordsImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterStopWords {

    @Test
    public void testExampleInputWithStopWords() {
        final IWordCounter wordCounter = new WordCounterStopWordsImpl("stopwords.txt");
        final String inputText = "Mary had a little lamb";
        assertEquals(4, wordCounter.count(inputText));
    }

    @Test
    public void testUniqueWordsWithStopWords() {
        final IWordCounter wordCounter = new WordCounterStopWordsImpl("stopwords.txt");
        final String inputText = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        assertEquals(9, wordCounter.count(inputText));
        assertEquals(7, wordCounter.countUnique(inputText));
    }
}
