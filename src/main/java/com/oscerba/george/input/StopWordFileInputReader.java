package com.oscerba.george.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StopWordFileInputReader extends StopWordInputReader {
    private Path path;

    public StopWordFileInputReader(Path path) {
        this.path = path;
    }

    @Override
    public List<String> getStopWords() throws IOException {
        return Files.readAllLines(path);
    }
}
