import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountServiceTest {

    private WordCountService wordCountService = new WordCountService();

    @Test
    public void countWords_testWordString() {
        int wordCount = wordCountService.count("Mary had a little lamb");
        assertEquals(5, wordCount);
    }

    @Test
    public void countWords_testAnotherWordString() {
        int wordCount = wordCountService.count("Mary had another very little lamb");
        assertEquals(6, wordCount);
    }

    @Test
    public void countWords_emptyString() {
        int wordCount = wordCountService.count("");
        assertEquals(0, wordCount);
    }

    @Test
    public void countWords_emptyString_withSingleSpace() {
        int wordCount = wordCountService.count(" ");
        assertEquals(0, wordCount);
    }

    @Test
    public void countWords_singleWord() {
        int wordCount = wordCountService.count("Hello");
        assertEquals(1, wordCount);
    }
}
