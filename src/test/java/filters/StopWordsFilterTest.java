package filters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StopWordsFilterTest {

    private StopWordsFilter stopWordsFilter;
    private Set<String> stopWords;


    @BeforeEach
    public void beforeEach() {
        stopWords = new HashSet<>();
        stopWords.add("the");
        stopWords.add("a");
        stopWords.add("on");
    }

    @Test
    public void whenSentenceIsNullNoFilteringHappens() {
        stopWordsFilter = new StopWordsFilter(stopWords);
        assertEquals("", stopWordsFilter.filter(null));
    }

    @Test
    public void whenSentenceIsEmptyNoFilteringHappens() {
        stopWordsFilter = new StopWordsFilter(stopWords);
        assertEquals("", stopWordsFilter.filter(""));
        assertEquals("", stopWordsFilter.filter(" "));
    }

    @Test
    public void filterStopWords() {
        final String input = "the Humpty-Dumpty sat on a wall";
        final String expectedOutput = "Humpty-Dumpty sat wall";

        stopWordsFilter = new StopWordsFilter(stopWords);
        assertEquals(expectedOutput, stopWordsFilter.filter(input));
    }
}