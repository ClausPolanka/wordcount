package com.oscerba.george.output;

public class ConsoleWriter implements Writeable {

    private long wordCount;

    public ConsoleWriter(long wordCount) {
        this.wordCount = wordCount;
    }

    @Override
    public void write() {
        System.out.println("Number of words: " + wordCount);
    }
}
