package com.erste.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountManagerTest {

    WordCountManager wordCountManager = new WordCountManager();

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"apple|1", "a|1", "pear|1"})
    public void testForSingleValidInput(String singleInput, long expectedValue) {
        long wordCount = wordCountManager.countWords(singleInput);
        assertEquals(wordCount, expectedValue);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"app2le|0", ",|0", " |0", "5465465|0"})
    public void testForSingleInvalidInput(String singleInvalidInput, long expectedValue) {
        long wordCount = wordCountManager.countWords(singleInvalidInput);
        assertEquals(wordCount, expectedValue);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"apple apple|2", "app3le pear|1", "apple3     333 222|0", "   apple !apple apple3 pear|3"})
    public void testForMultipleWordInputs(String input, long expectedValue) {
        long wordCount = wordCountManager.countWords(input);
        assertEquals(wordCount, expectedValue);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"apple|apple|0", "a|apple|1", "apple1|apple|0", "a1|apple|0", "|apple|0"})
    public void testForSingleInputWithStopWord(String input, String stopWord, long expectedValue) {
        long wordCount = wordCountManager.countWords(input, stopWord);
        assertEquals(wordCount, expectedValue);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value =
            {"apple apple ap2 pear|apple banana|1",
                    "apple pear banana strawberry blueberry|apple blueberry|3",
                    "apple pear apple||3",
                    "apple strawberry blueberry|apple strawberry blueberry|0"
    })
    public void testForMultipleWordsAsInputAndMultipleWordsAsStopWords(String input, String stopWords, long expectedValue) {
        long wordCount = wordCountManager.countWords(input, stopWords);
        assertEquals(wordCount, expectedValue);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value =
            {"apple apple banana strawberry|strawberry|2",
                    "apple apple apple|apple|0",
                    "apple apple apple||1",
                    "apple apple banana banana||2",
                    "apple. banana?||2"
            })
    public void testForUniqueCount(String input, String stopWords, long expectedValue) {
        long uniqueWordCount = wordCountManager.countUniqueWords("apple apple", "banana");
        assertEquals(uniqueWordCount, 1L);
    }

}
