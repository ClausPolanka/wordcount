package wordcount;

import org.junit.jupiter.api.Test;
import wordcount.impl.WordCounterAllowedDashImpl;
import wordcount.util.FileUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class WordCounterAllowedDashTest {

    @Test
    public void testAllowedDashWithStopWords() {
        final IWordCounter wordCounter = new WordCounterAllowedDashImpl("stopwords.txt");
        final String inputText = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        assertEquals(wordCounter.count(inputText), 7);
        assertEquals(wordCounter.countUnique(inputText), 6);
    }

    @Test
    public void testAverageWordLength() {
        final IWordCounter wordCounter = new WordCounterAllowedDashImpl("stopwords.txt");
        final String inputText = FileUtils.readFileAsString("src/test/resources/sometext.txt");
        assertEquals(19, wordCounter.count(inputText));
        assertEquals(17, wordCounter.countUnique(inputText));
        assertEquals(5.42, wordCounter.averageLength(inputText));
    }

    @Test
    public void testIndex() {
        final IWordCounter wordCounter = new WordCounterAllowedDashImpl("stopwords.txt");
        final String inputText = "Mary had a little lamb-chop";
        final List<String> expected = Arrays.asList("had", "lamb-chop", "little", "Mary");
        assertIterableEquals(expected, wordCounter.getIndex(inputText));
    }

    @Test
    public void testIndexWithDictionary() {
        final IWordCounter wordCounter = new WordCounterAllowedDashImpl("stopwords.txt");
        final String inputText = "Mary had a little lamb-chop";
        final List<String> expected = Arrays.asList("had", "lamb-chop*", "little", "Mary*");
        assertIterableEquals(expected, wordCounter.getIndex(inputText));
    }
}
