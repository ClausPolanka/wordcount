package com.oscerba.george.input;

import java.nio.file.Path;
import java.nio.file.Paths;

public class WordInputReaderFactory {

    public WordInputReader getWordInputReader(String[] args) {
        WordInputReader consoleWordInputReader;
        if (args.length > 0) {
            Path path = Paths.get(args[0]);
            consoleWordInputReader = new WordFileInputReader(path);
        } else {
            consoleWordInputReader = new WordConsoleInputReader();
        }
        return consoleWordInputReader;
    }

}
