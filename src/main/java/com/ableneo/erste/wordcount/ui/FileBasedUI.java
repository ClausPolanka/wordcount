package com.ableneo.erste.wordcount.ui;

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
    public void writeResults(int count) {
        System.out.println("Number of words: " + count);
    }
}
