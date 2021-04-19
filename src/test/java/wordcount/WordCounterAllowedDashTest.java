package wordcount;

import org.junit.jupiter.api.Test;
import wordcount.impl.WordCounterAllowedDashImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String inputText = new Main().readInput("src/test/resources/sometext.txt");
        final IWordCounter wordCounter = new WordCounterAllowedDashImpl("stopwords.txt");
        assertEquals(19, wordCounter.count(inputText));
        assertEquals(17, wordCounter.countUnique(inputText));
        assertEquals(5.42, wordCounter.averageLength(inputText));
    }
}
