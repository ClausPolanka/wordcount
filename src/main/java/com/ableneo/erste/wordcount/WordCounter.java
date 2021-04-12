package com.ableneo.erste.wordcount;

import java.util.Collections;
import java.util.List;

/**
 * Word counter
 */
public class WordCounter {

    private static final String WORD_SPLITTING_PATTERN = "([a-zA-Z]+)";

    private List<String> stopWords;

    /**
     * Constructor
     * @param stopWords words that should be ignored
     */
    public WordCounter(List<String> stopWords) {
        this.stopWords = stopWords == null ? Collections.emptyList() : stopWords;
    }

    /**
     * Counts words in input string. Stopwords are not counted.

     * @param input input string
     * @return number of words in input string, 0 if input is null.
     */
    public int count(String input) {
        if (input == null) {
            return 0;
        }

        int counter = 0;

        String[] tokens = input.split("\\s+");
        for (String token : tokens) {
            if (token.matches(WORD_SPLITTING_PATTERN) && !stopWords.contains(token)) {
                counter++;
            }
        }

        return counter;
    }
}
