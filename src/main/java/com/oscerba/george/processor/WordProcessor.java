package com.oscerba.george.processor;

import java.util.Arrays;
import java.util.regex.Pattern;

public class WordProcessor {

    private String[] words;
    public static final Pattern WORD_PATTRN = Pattern.compile("[a-zA-Z]+");

    public WordProcessor(String[] words) {
        this.words = words;
    }

    public long getCount() {
        return Arrays.stream(words).filter(word -> WORD_PATTRN.matcher(word).matches()).count();
    }
}
