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
}
