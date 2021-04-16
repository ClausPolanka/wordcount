package com.github.szsalyi.numbercount;

import com.github.szsalyi.wordcount.numbercount.StopWords;
import com.github.szsalyi.wordcount.numbercount.WordCheck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordCheckTest {
    private WordCheck wordCheck;

    @BeforeEach
    private void init() {
        MockStopWords mockStopWords = new MockStopWords(new HashSet<>());
        this.wordCheck = new WordCheck(mockStopWords);
    }

    @Test
    public void givenValidWord_whenIsValid_thenReturnTrue() {
        String singleWord = "word";

        boolean isValid = wordCheck.isValid(singleWord);

        assertTrue(isValid);
    }

    @Test
    public void givenWordWithNonAlphabeticChar_whenIsValid_thenReturnFalse() {
        String nonAlphabeticWord = "word,";

        boolean isValid = wordCheck.isValid(nonAlphabeticWord);

        assertFalse(isValid);
    }

    @Test
    public void givenEmptyString_whenIsValid_thenReturnFalse() {
        String nonAlphabeticWord = "";

        boolean isValid = wordCheck.isValid(nonAlphabeticWord);

        assertFalse(isValid);
    }

    @Test
    public void givenNull_whenIsValid_thenReturnFalse() {
        boolean isValid = wordCheck.isValid(null);

        assertFalse(isValid);
    }

    @Test
    public void givenValidStringWithoutStopWords_whenisValid_thenReturnTrue() {
        Set<String> stopWords = new HashSet<>(Collections.singletonList("the"));
        StopWords mockStopWord = new MockStopWords(stopWords);
        this.wordCheck = new WordCheck(mockStopWord);

        boolean isValid = this.wordCheck.isValid("word");

        assertTrue(isValid);
    }

    @Test
    public void givenValidStringWitStopWords_whenisValid_thenReturnFalse() {
        Set<String> stopWords = new HashSet<>(Collections.singletonList("the"));
        StopWords mockStopWord = new MockStopWords(stopWords);
        this.wordCheck = new WordCheck(mockStopWord);

        boolean isValid = this.wordCheck.isValid("the");

        assertFalse(isValid);
    }
}
