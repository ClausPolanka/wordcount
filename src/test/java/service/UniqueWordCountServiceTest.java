package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import service.WordCountService;
import util.FileBasedStopWords;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniqueWordCountServiceTest {

    private String input;
    private Integer output;
    private WordCountService wordCountService;

    @BeforeEach
    public void initialize() {

        FileBasedStopWords stopWords = new FileBasedStopWords();
        wordCountService = new WordCountService(stopWords);
    }

    private static List<Object> getIOPairs() {

        return Arrays.asList(new Object[][] {
                { "abc top abc", 2},
                { "abc top abcd", 3},
                { "", 0},
                { "a a a the abc", 1},
                { "A THE", 2},
                { "abc ABC", 2},
                { "a the a", 0}
        });
    }

    @ParameterizedTest
    @MethodSource("getIOPairs")
    public void testGetWordCount(String input, Integer output) {

        System.out.println("Parameterized Input is : " + input);
        System.out.println("Parameterized Output is : " + output);

        assertEquals(output, wordCountService.getUniqueWordCount(input));
    }
}
