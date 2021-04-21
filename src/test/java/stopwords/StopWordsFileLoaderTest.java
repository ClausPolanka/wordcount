package stopwords;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StopWordsFileLoaderTest {

    private StopWordsLoader loader;

    @Test
    public void testLoadingStopWordsFromFileNotFound() {
        loader = new StopWordsFileLoader("blahblah.txt");
        Set<String> stopWords = loader.loadStopWords();
        assertTrue(stopWords.isEmpty());
    }

    @Test
    public void testLoadingStopWordsFromExistingFile() {
        loader = new StopWordsFileLoader("stopwords.txt");
        Set<String> stopWords = loader.loadStopWords();
        assertFalse(stopWords.isEmpty());
    }

}