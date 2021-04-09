package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.ParameterizedTest.*;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.FileBasedStopWords;

import java.util.Arrays;
import java.util.Collection;
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

    private List<Object> getIOPairs() {

    return Arrays.asList(new Object[][] {
                { "abc def .k", 2},
                { "abc", 1},
                { " abc   def", 2},
                { "", 0},
                { "&*(", 0},
                { ".   ABC", 1},
                { "abc d1ef", 1},
                { "abc a", 1},
                { "a the", 1},
                {"   ABC", 1},
                {"abc THE", 1}
        });
    }

    public WordCountServiceTest(String input, Integer output) {
        this.input = input;
        this.output = output;
    }


    @ParameterizedTest
    @MethodSource("getIOPairs")
    public void testPrimeNumberChecker() {
        System.out.println("Parameterized Input is : " + input);

        assertEquals(output, wordCountService.getWordCount(input));
    }

    /*
    @Test
    public void testGetUniqueWordCount_DuplicateWords() {

        WordCountService wordCountService = setUpService();

        String str = "abc top abc";
        assertEquals(2, wordCountService.getUniqueWordCount(str));

    }

    @Test
    public void testGetUniqueWordCount_StopWords() {

        WordCountService wordCountService = setUpService();

        String str = "a the a";
        assertEquals(0, wordCountService.getUniqueWordCount(str));
    }

    @Test
    public void testGetUniqueWordCount_NoDuplicates() {

        WordCountService wordCountService = setUpService();

        str = "abc top abcd";
        assertEquals(3, wordCountService.getUniqueWordCount(str));

    }

    private WordCountService setUpService(){

        FileBasedStopWords stopWords = new FileBasedStopWords();
        WordCountService wordCountService = new WordCountService(stopWords);

        return wordCountService;

    } */

}
