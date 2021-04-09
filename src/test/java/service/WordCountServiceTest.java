package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.FileBasedStopWords;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountServiceTest {

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
                { "abc def .k", 2},
                { "abc", 1},
                { " abc   def", 2},
                { "", 0},
                { "&*(", 0},
                { ".   ABC", 1},
                { "abc d1ef", 1},
                { "abc a", 1},
                { "a the", 0},
                {"   ABC", 1},
                {"abc THE", 2}
        });
    }


    @ParameterizedTest
    @MethodSource("getIOPairs")
    public void testGetWordCount(String input, Integer output) {

        System.out.println("Parameterized Input is : " + input);
        System.out.println("Parameterized Output is : " + output);

        assertEquals(output, wordCountService.getWordDetails(input).getCount());
    }

}
