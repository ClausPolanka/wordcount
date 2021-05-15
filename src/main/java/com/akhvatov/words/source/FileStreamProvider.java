package com.akhvatov.words.source;

import com.akhvatov.words.WordCountApp;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Convenient class for reading all lines from file as a stream
 */
public class FileStreamProvider {

    private final String filename;

    public static Stream<String> from(String filename) {
        return new FileStreamProvider(filename).readLines();
    }

    private FileStreamProvider(String filename) {
        this.filename = filename;
    }

    private Stream<String> readLines() {
        final URL resource = WordCountApp.class.getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException(String.format("Can't find %s file", filename));
        }

        try {
            return Files.lines(Paths.get(resource.toURI()));
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(String.format("Error while reading %s file", filename));
        }
    }
}
