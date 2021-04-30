package com.oscerba.george.processor;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordProcessor {

    private List<String> words;
    private List<String> stopWords;
    public static final Pattern WORD_PATTRN = Pattern.compile("[a-zA-Z]+");

    public WordProcessor(List<String> words, List<String> stopWords) {
        this.words = words;
        this.stopWords = stopWords;
    }

    public long getCount() {
        return words.stream().filter(word -> WORD_PATTRN.matcher(word).matches() && !stopWords.contains(word)).count();
    }
}
