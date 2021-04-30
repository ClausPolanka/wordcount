package com.oscerba.george.processor;

import com.oscerba.george.pojo.Word;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordProcessor {

    private final Set<String> dictionary;
    private final List<Word> words;
    public static final Pattern WORD_PATTERN = Pattern.compile("[a-zA-Z-]+\\.?");

    public WordProcessor(List<String> words, List<String> stopWords, Set<String> dictionary) {
        this.dictionary = dictionary;
        this.words = words.stream().filter(
                word -> WORD_PATTERN.matcher(word).matches() && !stopWords.contains(word))
                .map(word -> new Word(word, dictionary.contains(word)))
                .collect(Collectors.toList());
    }

    public WordStatistics getStatistics() {
        return new WordStatistics(words);
    }
}
