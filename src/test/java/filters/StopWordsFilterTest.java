package filters;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class StopWordsFilterTest {

    private StopWordsFilter stopWordsFilter;


    @Test
    void filterStopWords() {
        Set<String> stopWords = new HashSet<>();
        stopWords.add("the");
        stopWords.add("a");
        stopWords.add("on");

        final String input = "Humpty-Dumpty sat on a wall";

        stopWordsFilter = new StopWordsFilter(stopWords);
//        stopWordsFilter.filter("")
    }
}