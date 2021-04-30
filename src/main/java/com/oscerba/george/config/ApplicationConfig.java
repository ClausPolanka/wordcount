package com.oscerba.george.config;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ApplicationConfig {
    public static final String STOPWORDS_INPUT = "src/main/resources/stopwords.txt";

    private final boolean indexEnabled;
    private final Path wordsInputFilePath;
    private final Path stopWordsInputFilePath = Paths.get(STOPWORDS_INPUT);

    public ApplicationConfig(boolean indexEnabled, Path wordsInputFilePath) {
        this.indexEnabled = indexEnabled;
        this.wordsInputFilePath = wordsInputFilePath;
    }

    public boolean isIndexEnabled() {
        return indexEnabled;
    }

    public Path getWordsInputFilePath() {
        return wordsInputFilePath;
    }

    public Path getStopWordsInputFilePath() {
        return stopWordsInputFilePath;
    }
}
