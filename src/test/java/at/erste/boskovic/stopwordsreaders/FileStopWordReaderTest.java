package at.erste.boskovic.stopwordsreaders;

import at.erste.boskovic.StopWordsReader;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileStopWordReaderTest {

    public static final String STOPWORDS_TEST_FILE = "stopword_test_files/test_stopwords.txt";

    @Test
    public void shouldHaveNoStopwordsIfIncorrectFile(){
        StopWordsReader stopWordsReader = new FileStopWordReader(STOPWORDS_TEST_FILE);
        List<String> stopwords = stopWordsReader.readStopwords();
        assertFalse(stopwords.isEmpty());
        assertEquals(4, stopwords.size());
        List<String> testStopwords = Arrays.asList("test_the", "test_a", "test_on", "test_off");
        for (String testStopword : testStopwords){
            assertTrue(stopwords.contains(testStopword));
        }
    }

}