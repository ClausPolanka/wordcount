package com.wordcount;

import java.util.Arrays;


public class WordCounter {

    public static final String DELIMITER = " ";

    /***
     * Count number of words from the input text
     * @param wordInput is a scanner input
     * @return number of words
     */
    public long countWords(String wordInput) {
        String[] splitInput = wordInput.split(DELIMITER);
        //List wordList = Arrays.asList(splitInput);
        return Arrays.stream(splitInput)
                .filter(s -> !s.isEmpty())
                .filter(this::containsOnlyLetters).count();
    }

    /**
     * checks if the input parameter is contains only letter
     * @param word should contain only letters
     * @return should true/false
     */
    private boolean containsOnlyLetters(String word) {
        return word.chars().allMatch(Character::isLetter);
    }
}

