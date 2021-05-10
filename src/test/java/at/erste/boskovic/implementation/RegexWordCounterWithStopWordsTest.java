package at.erste.boskovic.implementation;

import at.erste.boskovic.WordCounter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegexWordCounterWithStopWordsTest {

    private static final List<String> STOPWORDS = Arrays.asList("the", "a", "on", "off");

    @Test
    void shouldCountRegularWords(){
        test("word word word", 3);
    }

    @Test
    void shouldNotCountStopWords(){
        test("word the word a word on", 3);
    }

    @Test
    void shouldNotCountStopWordsAndSpecialCharacters(){
        test("word word3 word word off word", 4);
    }

    @Test
    void shouldNotCountNumbers(){
        test("word 123 sentence", 2);
    }

    @Test
    void shouldWorkForMultipleWhitespaces() {
        test("word\rword\nword\tword\noff", 4);
    }

    @Test
    void shouldNotCountWithSpecialCharacters(){
        test("word word$ word of$ off", 2);
    }

    @Test
    void shouldCountZeroForEmptySpaceOrNull(){
        test("", 0);
        test(null, 0);
    }

    private void test(String sentence, long expectedCount){
        WordCounter wordCounter = new RegexWordCounter(STOPWORDS);

        assertEquals(expectedCount, wordCounter.countWords(sentence));
    }



}
