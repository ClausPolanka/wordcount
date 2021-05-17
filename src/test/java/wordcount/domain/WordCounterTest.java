package wordcount.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

class WordCounterTest {

    public static final String BASE_INPUT = "Mary had a little lamb";
    private WordCounter sut;

    @Test
    void should_Return_0_When_Text_Is_Null() {
        sut = new WordCounter(emptyList());

        long actual = sut.count(null);

        Assertions.assertEquals(0, actual);
    }

    @ParameterizedTest
    @CsvSource({
            ",0",
            "         ,0",
            "Mary had a little lamb,5",
            "           word    word                             word                 ,3",
            "word,1",
            "WORD,1"
    })
    void should_Count_Return_Count(String input, long expected) {
        sut = new WordCounter(emptyList());

        long actual = sut.count(input);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "wo$d word,1",
            "wo3d word word?,1",
            "word; word. word! word,1"
    })
    void should_Count_Only_Legal_Words(String input, long expected) {
        sut = new WordCounter(emptyList());

        long actual = sut.count(input);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "off the on,0",
            "Mary had a little lamb,4",
            "off out,1"
    })
    void should_Count_Skip_Stop_Words(String input, long expected) {
        sut = new WordCounter(asList("the", "a", "on", "off"));

        long actual = sut.count(input);

        Assertions.assertEquals(expected, actual);
    }
}