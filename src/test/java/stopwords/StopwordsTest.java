package stopwords;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StopwordsTest {

    @Test
    public void whenGetStopwords_thenReturnList() {
        List<String> stopwords = Stopwords.getStopwords();

        assertEquals(4, stopwords.size());
        assertTrue(stopwords.contains("the"));
        assertTrue(stopwords.contains("a"));
        assertTrue(stopwords.contains("on"));
        assertTrue(stopwords.contains("off"));
    }
}
