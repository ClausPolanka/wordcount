package wordcount.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WordCounterTest {

    private WordCounter sut = new WordCounter(stopWords);

    @Test
    void should_Return_0_When_Text_Is_Null() {
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
        long actual = sut.count(input);

        Assertions.assertEquals(expected, actual);
    }
}