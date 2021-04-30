package com.oscerba.george.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class WordFileInputReader extends WordInputReader{
    private Path path;

    public WordFileInputReader(Path path) {
        this.path = path;
    }

    @Override
    public String getWords() throws IOException {
        return String.join(" ", Files.readAllLines(path));
    }
}
