package com.oscerba.george.input;

import java.nio.file.Path;

public class WordInputReaderFactory {

    public WordInputReader getWordInputReader(Path inputFilePath) {
        WordInputReader consoleWordInputReader;
        if (inputFilePath != null) {
            consoleWordInputReader = new WordFileInputReader(inputFilePath);
        } else {
            consoleWordInputReader = new WordConsoleInputReader();
        }
        return consoleWordInputReader;
    }

}
