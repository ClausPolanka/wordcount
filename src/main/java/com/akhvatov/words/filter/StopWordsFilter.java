package com.akhvatov.words.filter;

import com.akhvatov.words.State;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Word Count II: Not all words are relevant for counting. A list of stop words (provided in the file „stopwords.txt“)
 * defines which words not to count.
 */
public class StopWordsFilter implements Filter {

    private final Set<String> stopWords;

    public StopWordsFilter(Stream<String> stopWords) {
        this.stopWords = stopWords.map(String::toUpperCase).collect(Collectors.toSet());
    }

    @Override
    public boolean test(String word, State state) {
        return !stopWords.contains(word.toUpperCase());
    }
}
