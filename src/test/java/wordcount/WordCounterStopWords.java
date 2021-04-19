package wordcount;

import org.junit.jupiter.api.Test;
import wordcount.impl.WordCounterStopWordsImpl;
import wordcount.util.FileUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

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

    @Test
    public void testAverageWordLength() {
        final IWordCounter wordCounter = new WordCounterStopWordsImpl("stopwords.txt");
        String inputText = FileUtils.readFileAsString("src/test/resources/sometext.txt");
        assertEquals(20, wordCounter.count(inputText));
        assertEquals(16, wordCounter.countUnique(inputText));
        assertEquals(5.1, wordCounter.averageLength(inputText));
    }

    @Test
    public void testIndex() {
        final IWordCounter wordCounter = new WordCounterStopWordsImpl("stopwords.txt");
        final String inputText = "Mary had a little lamb-chop";
        final List<String> expected = Arrays.asList("chop", "had", "lamb", "little", "Mary");
        assertIterableEquals(expected, wordCounter.getIndex(inputText));
    }
}
