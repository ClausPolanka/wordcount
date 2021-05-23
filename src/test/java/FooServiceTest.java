import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.WordMapKeys;
import src.main.java.service.FooService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooServiceTest {

    private FooService testSubject = new FooService("src/test/resources/stopwords.txt");

    @Test
    public void testCountTotalWordsOnlyFromText()
    {
        Map<String, Double> value = testSubject.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.",null, false, false);
        assertEquals(2, value.size());
        assertEquals(10, value.get(WordMapKeys.TOTAL_WORDS.getKeyNameValue()));
    }

    @Test
    public void testCountTotalWordsWithStopperFromFile()
    {
        Map<String,Double> value = testSubject.countWords(null, "src/test/resources/input.txt", true, false);
        assertEquals(3, value.size());
        assertEquals(5, value.get(WordMapKeys.TOTAL_WORDS.getKeyNameValue()));
        assertEquals(3, value.get(WordMapKeys.TOTAL_WORDS_WITH_STOPPER.getKeyNameValue()));
    }

    @Test
    public void testCountAllTypesAndAvgFromFile()
    {
        Map<String,Double> value = testSubject.countWords(null, "src/test/resources/input.txt", true, true);
        assertEquals(4, value.size());
        assertEquals(5, value.get(WordMapKeys.TOTAL_WORDS.getKeyNameValue()));
        assertEquals(3, value.get(WordMapKeys.TOTAL_WORDS_WITH_STOPPER.getKeyNameValue()));
        assertEquals(5, value.get(WordMapKeys.UNIQUE_WORDS.getKeyNameValue()));
        assertEquals(3.6, value.get(WordMapKeys.TOTAL_AVG.getKeyNameValue()));
    }
}
