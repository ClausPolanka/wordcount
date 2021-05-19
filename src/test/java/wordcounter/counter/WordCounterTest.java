package wordcounter.counter;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    private final WordCounter wordCounter = new WordCounter(Stream.of("the", "a", "on", "off").collect(Collectors.toList()));

    @Test
    void shouldHave1WordIn1AlphabeticWord() {
        wordCounter.setText("word");
        assertEquals(wordCounter.countWords(), 1);
    }

    @Test
    void shouldHave2WordsIn2AlphabeticWords() {
        wordCounter.setText("word word");
        assertEquals(wordCounter.countWords(), 2);
    }

    @Test
    void shouldHave0WordsIfNumberIsInWords() {
        wordCounter.setText("wo4rD");
        assertEquals(wordCounter.countWords(), 0);
    }

    @Test
    void shouldHave0WordsIfSpecialCharIsInWords() {
        wordCounter.setText("wo$rd");
        assertEquals(wordCounter.countWords(), 0);
    }

    @Test
    void shouldHave0WordsIfNothingInputted() {
        wordCounter.setText("");
        assertEquals(wordCounter.countWords(), 0);
    }

    @Test
    void shouldHave3WordsWithWhitespace() {
        wordCounter.setText("           word           word                 word     ");
        assertEquals(wordCounter.countWords(), 3);
    }

    @Test
    void shouldHave6WordsWithStopWords() {
        wordCounter.setText("Mary had a little lamb and a big");
        assertEquals(wordCounter.countWords(), 6);
    }
}
