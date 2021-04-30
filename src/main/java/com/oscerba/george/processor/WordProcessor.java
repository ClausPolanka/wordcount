package com.oscerba.george.processor;

import com.oscerba.george.pojo.WordStatistics;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordProcessor {

    private List<String> words;
    public static final Pattern WORD_PATTERN = Pattern.compile("[a-zA-Z]+");

    public WordProcessor(List<String> words, List<String> stopWords) {
        this.words = words.stream().filter(word -> WORD_PATTERN.matcher(word).matches() && !stopWords.contains(word)).collect(Collectors.toList());
    }

    public WordStatistics getStatistics(){
        return new WordStatistics(words.size(), words.stream().distinct().count());
    }
}
