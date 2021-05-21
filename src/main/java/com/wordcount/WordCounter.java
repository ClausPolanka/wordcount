package com.wordcount;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class WordCounter {

    private static final Pattern ONLY_CHARACTERS = Pattern.compile("^[a-zA-Z]+$");
    private static final String WHITESPACE_REGEX = "\\s+";

    public int countWords(String text) {
        if (Objects.isNull(text)) {
            return 0;
        }
        String[] allWords = text.split(WHITESPACE_REGEX);
        return (int) Arrays.stream(allWords).filter(word -> ONLY_CHARACTERS.matcher(word).matches()).count();
    }
}
