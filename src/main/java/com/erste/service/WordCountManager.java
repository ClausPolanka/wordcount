package com.erste.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordCountManager {

    public long countWords(String input) {
        if (input == null) {
            return 0;
        }
        String[] potentialWords = input.split("\\s");

        return Arrays.stream(potentialWords).filter(pw -> pw.matches("[a-zA-Z]+")).count();
    }

    public long countWords(String input, String stopWords) {
        if (stopWords == null) {
            return countWords(input);
        }

        String[] stopWordsAsArray = stopWords.split("\\s");
        Set<String> stopWordsAsSet = new HashSet<>(Arrays.asList(stopWordsAsArray));
        String[] potentialWords = input.split("\\s");

        return Arrays.stream(potentialWords).filter(pw -> pw.matches("[a-zA-Z]+")).filter(pw -> !stopWords.contains(pw)).count();
    }

}
