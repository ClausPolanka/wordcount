package com.github.szsalyi.numbercount;

import com.github.szsalyi.wordcount.numbercount.WordCheck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordCheckTest {
    private WordCheck wordCheck;

    @BeforeEach
    private void init() {
        this.wordCheck = new WordCheck();
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
}
