package com.github.szsalyi.wordcount.io;

import com.github.szsalyi.wordcount.numbercount.WordCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public class WordCounterTest {

    private WordCounter wordCounter;

    @BeforeEach
    private void init() {

    }

    @Test
    public void givenInputSingleString_whenWordCount_thenReturnOne() {
        TestUserIO testUserIO = new TestUserIO();
        this.wordCounter = new WordCounter();

        wordCounter.count();
    }


}
