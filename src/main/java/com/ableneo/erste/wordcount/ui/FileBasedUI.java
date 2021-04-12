package com.ableneo.erste.wordcount.ui;

import com.ableneo.erste.wordcount.counter.CounterResult;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileBasedUI implements UI {

    private final String fileName;

    public FileBasedUI(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public InputStream getInput() throws IOException {
        return new FileInputStream(fileName);
    }

    @Override
    public void writeResults(CounterResult result) {
        System.out.printf("Number of words: %d, unique: %d%n", result.getTotal(), result.getUnique());
    }
}
