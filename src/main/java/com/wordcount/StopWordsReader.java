package com.wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordsReader {

    public static final String MAIN_RESOURCES_STOPWORDS_TXT = "src/main/resources/stopwords.txt";

    public Set<String> readStopWords() {
        try {
            Path path = Paths.get(MAIN_RESOURCES_STOPWORDS_TXT);
            return Files.readAllLines(path).stream().map(String::trim).collect(Collectors.toSet());
        } catch (IOException e) {
            System.out.printf("Stopwords file was not loaded. Cause: '%s'%n", e.getMessage());
            return new HashSet<>();
        }
    }
}
