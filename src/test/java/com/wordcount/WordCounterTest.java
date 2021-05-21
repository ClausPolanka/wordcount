package com.wordcount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private final WordCounter counter = new WordCounter(new StopWordsReader());

    @ParameterizedTest
    @CsvSource(value = {
            "word word;2",
            "              word              word                        word                           ;3",
            "wo3d;0",
            "wo$d;0",
            "word, word? word. word;1",
            "NIL;0",
            ";0"
    }, nullValues = "NIL", delimiter = ';')
    public void thatWordsWithNonAlphabeticalCharactersAndNullsAreNotCounted(String text, int expectedAllWordsCount) {
        WordCounterResult counterResult = counter.countWords(text);
        assertEquals(expectedAllWordsCount, counterResult.getAllWordsCount());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "word the;1",
            "word the a on off an;2",
            "word;1"
    }, nullValues = "NIL", delimiter = ';')
    public void thatStopWordsAreNotCounted(String text, int expectedAllWordsCount) {
        WordCounterResult counterResult = counter.countWords(text);
        assertEquals(expectedAllWordsCount, counterResult.getAllWordsCount());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "word word;2;1",
            "word the a on off an;2;2",
            "word worda wordb word;4;3",
            "NIL;0;0",
            ";0;0"
    }, nullValues = "NIL", delimiter = ';')
    public void thatUniquesWordsAreCountedCorrectly(String text, int expectedAllWordsCount, int expectedUniqueWordsCount) {
        WordCounterResult counterResult = counter.countWords(text);
        assertEquals(expectedAllWordsCount, counterResult.getAllWordsCount());
        assertEquals(expectedUniqueWordsCount, counterResult.getUniqueWordsCount());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "word word;4",
            "word wordb wordbb;5",
            "word;4",
            "NIL;0",
            ";0"
    }, nullValues = "NIL", delimiter = ';')
    public void thatAverageWordLengthIsCalculated(String text, double expectedAverage) {
        WordCounterResult counterResult = counter.countWords(text);
        assertEquals(expectedAverage, counterResult.getAverageWordLength());
    }

    @Test
    public void thatWordWithHyphenIsCounted() {
        WordCounterResult counterResult = counter.countWords("word-with-hypen");
        assertEquals(1, counterResult.getAllWordsCount());
        assertEquals(1, counterResult.getUniqueWordsCount());
    }
}