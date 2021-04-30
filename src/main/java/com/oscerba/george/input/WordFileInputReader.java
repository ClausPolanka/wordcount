package com.oscerba.george.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WordFileInputReader extends WordInputReader{
    private Path path;

    public WordFileInputReader(Path path) {
        this.path = path;
    }

    @Override
    public List<String> getWords() throws IOException {
        return Files.readAllLines(path);
    }
}
