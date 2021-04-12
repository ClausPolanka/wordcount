package com.ableneo.erste.wordcount;

/**
 * Word counter
 */
public class WordCounter {

    private static final String WORD_SPLITTING_PATTERN = "([a-zA-Z]+)";

    /**
     * Counts words in input string

     * @param input input string
     * @return number of words in input string, 0 if input is null
     */
    public int count(String input) {
        if (input == null) {
            return 0;
        }

        int counter = 0;

        String[] tokens = input.split("\\s+");
        for (String token : tokens) {
            if (token.matches(WORD_SPLITTING_PATTERN)) {
                counter++;
            }
        }

        return counter;
    }
}
