import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountServiceTest {

    private WordCountService wordCountService = new WordCountService();

    @Test
    public void countWords_test1() {
        List<String> words = Arrays.asList("Mary", "had", "a", "little", "lamb");
        int wordCount = wordCountService.count(words);
        assertEquals(4, wordCount);
    }

    @Test
    public void countWords_test2() {
        List<String> words = Arrays.asList("Mary", "had", "another", "very","little", "lamb");
        int wordCount = wordCountService.count(words);
        assertEquals(6, wordCount);
    }

    @Test
    public void countWords_emptyString() {
        List<String> words = Arrays.asList("");
        int wordCount = wordCountService.count(words);
        assertEquals(0, wordCount);
    }

    @Test
    public void countWords_emptyString_withSingleSpace() {
        List<String> words = Arrays.asList(" ");
        int wordCount = wordCountService.count(words);
        assertEquals(0, wordCount);
    }

    @Test
    public void countWords_singleWord() {
        List<String> words = Arrays.asList("Hello");
        int wordCount = wordCountService.count(words);
        assertEquals(1, wordCount);
    }

    @Test
    public void countWords_onlyStopWords() {
        List<String> words = Arrays.asList("the", "a", "on", "off");
        int wordCount = wordCountService.count(words);
        assertEquals(0, wordCount);
    }

    @Test
    public void countWords_mixtureBetween_stopwords_and_nonStopwords() {
        List<String> words = Arrays.asList("the", "Mary", "a", "little", "lamb", "on", "her", "last", "trip", "off", "wool");
        int wordCount = wordCountService.count(words);
        assertEquals(7, wordCount);
    }


}
