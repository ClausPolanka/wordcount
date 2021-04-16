package com.github.szsalyi.wordcount.io;

import com.github.szsalyi.wordcount.numbercount.UserIO;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public class TestUserIO implements UserIO {
    @Override
    public String userInput() {
        return "Some string";
    }

    @Override
    public void printResult(long wordCount) {

    }
}
