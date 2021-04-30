package com.oscerba.george.processor;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordProcessor {

    private String[] words;
    private List<String> stopWords;
    public static final Pattern WORD_PATTRN = Pattern.compile("[a-zA-Z]+");

    public WordProcessor(String[] words, List<String> stopWords) {
        this.words = words;
        this.stopWords = stopWords;
    }

    public long getCount() {
        return Arrays.stream(words).filter(word -> WORD_PATTRN.matcher(word).matches() && !stopWords.contains(word)).count();
    }
}
