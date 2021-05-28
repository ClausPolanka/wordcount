package com.erste.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordCountManager {

    public long countWords(String input) {
        if (input == null) {
            return 0;
        }
        String[] potentialWords = getPotentialWords(input);

        return Arrays.stream(potentialWords).filter(pw -> pw.matches("[a-zA-Z]+")).count();
    }

    public long countWords(String input, String stopWords) {
        long resultOfInputCheck = checkInputAndStopWords(input, stopWords);
        if (resultOfInputCheck != -1L) {
            return resultOfInputCheck;
        }

        Set<String> stopWordsAsSet = getStopWordsAsSet(stopWords);
        String[] potentialWords = getPotentialWords(input);

        return Arrays.stream(potentialWords).filter(pw -> pw.matches("[a-zA-Z]+")).filter(pw -> !stopWordsAsSet.contains(pw)).count();
    }

    public long countUniqueWords(String input, String stopWords) {
        long resultOfInputCheck = checkInputAndStopWords(input, stopWords);
        if (resultOfInputCheck != -1L) {
            return resultOfInputCheck;
        }

        Set<String> stopWordsAsSet = getStopWordsAsSet(stopWords);
        String[] potentialWords = getPotentialWords(input);

        return Arrays.stream(potentialWords).filter(pw -> pw.matches("[a-zA-Z]+")).filter(pw -> !stopWordsAsSet.contains(pw)).distinct().count();
    }

    String[] getPotentialWords(String input) {
        return input.replaceAll("[^A-Za-z0-9]"," ").split("\\s");
    }

    Set<String> getStopWordsAsSet(String stopWords) {
        String[] stopWordsAsArray = stopWords.split("\\s");
        return new HashSet<>(Arrays.asList(stopWordsAsArray));
    }


    public long checkInputAndStopWords(String input, String stopWords) {
        if (input == null) {
            return 0;
        }

        if (stopWords == null) {
            return countWords(input);
        }

        return -1L;
    }

}
