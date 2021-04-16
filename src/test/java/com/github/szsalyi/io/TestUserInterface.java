package com.github.szsalyi.io;

import com.github.szsalyi.wordcount.numbercount.UserInterface;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public class TestUserInterface implements UserInterface {
    private String testContent;

    public TestUserInterface(String testContent) {
        this.testContent = testContent;
    }

    @Override
    public String userInput() {
        return testContent;
    }

    @Override
    public void printResult(long wordCount) {

    }
}
