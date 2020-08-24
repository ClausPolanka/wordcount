import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordCountMainTest {

    @Test
    public void testSingleWord() throws IOException {
        WordCountMain app = new WordCountMain();
        assertEquals(1, app.wordCount("word"));
    }

    @Test
    public void testNotSingleWord() throws IOException {
        WordCountMain app = new WordCountMain();
        assertEquals(0, app.wordCount("word2"));
    }

    @Test
    public void testSeveralWords() throws IOException {
        WordCountMain app = new WordCountMain();
        assertEquals(4, app.wordCount("Mary had a little lamb"));
    }

    @Test
    public void testReadStopwords() throws IOException {
        WordCountMain app = new WordCountMain();
        assertTrue(app.stopwords.contains("the"));
        assertTrue(app.stopwords.contains("a"));
        assertTrue(app.stopwords.contains("on"));
        assertTrue(app.stopwords.contains("off"));
    }
}
