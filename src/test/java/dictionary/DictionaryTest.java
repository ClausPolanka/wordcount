package dictionary;

import org.junit.jupiter.api.Test;
import wordcounter.WordCounterUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DictionaryTest {

    @Test
    public void test() {
        List<String> inputWords = WordCounterUtils.retrieveWordsFromUserInput("Mary had a little lamb");
        List<String> words = Dictionary.searchInDictionary(inputWords);

        assertEquals(4, words.size());
        assertTrue(words.containsAll(Arrays.asList("Mary*", "lamb*", "little", "had")));
    }
}
