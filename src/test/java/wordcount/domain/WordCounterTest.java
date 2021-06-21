package wordcount.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.ResourceFetcher;
import wordcount.io.StopWordReader;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    WordCounter wc;

    @BeforeEach
    void setup() {
        wc = new WordCounter();
    }


    @ParameterizedTest
    @MethodSource("paramsforcCountWords")
    void countWords(String text, Long count) {
        ResourceFetcher resourceFetcher = new ResourceFetcher();
        StopWordReader sr = new StopWordReader(resourceFetcher);
        assertEquals(count, wc.countWords(text,  sr.readStopWords()));

    }
    public static Iterable<Object[]> paramsforcCountWords() {
       return Arrays.asList(new Object[][] {
               {"Hello Text", 2L},
               {"whatever $asdas", 1L},
               {"tru1e true", 1L},
               {"whatever the", 1L},
               {"whatever a", 1L},
               {"whatever on", 1L},
               {"whatever off", 1L}}
       );
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "whatever", "true"})
    void isValid(String arg) {

       assertEquals(true, wc.isValid(arg));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hell$o", "1whatever", "tru_e"})
    void isNotValid(String arg) {

        assertEquals(false, wc.isValid(arg));
    }
}
