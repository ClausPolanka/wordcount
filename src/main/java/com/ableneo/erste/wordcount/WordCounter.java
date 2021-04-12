package com.ableneo.erste.wordcount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private static final Pattern PATTERN = Pattern.compile("([a-zA-Z]+)\\s|\\b");

    public int count(String input) {
        if (input == null) {
            return 0;
        }

        int counter = 0;

        Matcher m = PATTERN.matcher(input);

        while (m.find()) {
            counter++;
        }

        return counter;
    }
}
