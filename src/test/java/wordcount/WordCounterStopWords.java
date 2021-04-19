package wordcount;

import org.junit.jupiter.api.Test;
import wordcount.impl.WordCounterStopWordsImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterStopWords {

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
        assertEquals(wordCounter.count(inputText), 9);
        assertEquals(wordCounter.countUnique(inputText), 7);
    }
}
