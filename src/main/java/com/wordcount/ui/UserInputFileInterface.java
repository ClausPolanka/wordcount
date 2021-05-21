package com.wordcount.ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserInputFileInterface implements InputInterface {

    private final String pathToFile;

    public UserInputFileInterface(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public String getInput() {
        try {
            Path path = Paths.get(pathToFile);
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            System.err.printf("User Input file cannot be loaded. Cause: '%s'%n", e.getMessage());
            throw new IllegalArgumentException("User Input file cannot be loaded", e);
        }
    }
}
