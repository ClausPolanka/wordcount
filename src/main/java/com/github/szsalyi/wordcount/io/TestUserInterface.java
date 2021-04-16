package com.github.szsalyi.wordcount.io;

import com.github.szsalyi.wordcount.numbercount.UserInterface;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public class TestUserInterface implements UserInterface {
    @Override
    public String userInput() {
        return "Some string";
    }

    @Override
    public void printResult(long wordCount) {

    }
}
