package com.ableneo.erste.wordcount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private static final Pattern PATTERN = Pattern.compile(".*(\\w+).*");

    public int count(String input) {
        if (input == null) {
            return 0;
        }

        Matcher m = PATTERN.matcher(input);
        if (m.matches()) {

        }

        return 0;
    }
}
