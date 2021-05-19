package wordcounter.counter;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    private final WordCounter wordCounter = new WordCounter(Stream.of("the", "a", "on", "off").collect(Collectors.toList()));

    @Test
    void shouldHave1WordIn1AlphabeticWord() {
        assertEquals(wordCounter.countWordsIn("word"), 1);
    }

    @Test
    void shouldHave2WordsIn2AlphabeticWords() {
        assertEquals(wordCounter.countWordsIn("word word"), 2);
    }

    @Test
    void shouldHave0WordsIfNumberIsInWords() {
        assertEquals(wordCounter.countWordsIn("wo4rD"), 0);
    }

    @Test
    void shouldHave0WordsIfSpecialCharIsInWords() {
        assertEquals(wordCounter.countWordsIn("wo$rd"), 0);
    }

    @Test
    void shouldHave0WordsIfNothingInputted() {
        assertEquals(wordCounter.countWordsIn(""), 0);
    }

    @Test
    void shouldHave3WordsWithWhitespace() {
        assertEquals(wordCounter.countWordsIn("           word           word                 word     "), 3);
    }

    @Test
    void shouldHave6WordsWithStopWords() {
        assertEquals(wordCounter.countWordsIn("Mary had a little lamb and a big"), 6);
    }
}
