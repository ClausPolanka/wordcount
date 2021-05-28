package com.erste.service;

import java.util.Arrays;

public class WordCountManager {

    public long countWords(String input) {
        if (input == null) {
            return 0;
        }
        String[] potentialWords = input.split("\\s");

        return Arrays.stream(potentialWords).filter(pw -> pw.matches("[a-zA-Z]+")).count();
    }

}
