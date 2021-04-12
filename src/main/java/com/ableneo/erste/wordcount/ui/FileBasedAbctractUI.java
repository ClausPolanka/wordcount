package com.ableneo.erste.wordcount.ui;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileBasedAbctractUI extends AbctractUI {

    private final String fileName;

    public FileBasedAbctractUI(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public InputStream getInput() throws IOException {
        return new FileInputStream(fileName);
    }
}
