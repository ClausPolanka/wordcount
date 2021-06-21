package wordcount.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    void countWords() {
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "whatever", "true"})
    void isValid(String arg) {
       WordCounter wc = new WordCounter();

       assertEquals(true, wc.isValid(arg));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hell$o", "1whatever", "tru_e"})
    void isNotValid(String arg) {
        WordCounter wc = new WordCounter();

        assertEquals(false, wc.isValid(arg));
    }
}
