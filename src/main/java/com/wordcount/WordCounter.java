package com.wordcount;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {

    private static final Pattern ONLY_CHARACTERS = Pattern.compile("^[a-zA-Z]+$");
    private static final String WHITESPACE_REGEX = "\\s+";

    private final Set<String> stopWords;

    public WordCounter(StopWordsReader stopWordsReader) {
        this.stopWords = stopWordsReader.readStopWords();
    }

    public WordCounterResult countWords(String text) {
        if (Objects.isNull(text)) {
            return new WordCounterResult(0, 0);
        }

        String[] allWords = text.split(WHITESPACE_REGEX);
        List<String> matchedWords =  Arrays.stream(allWords)
                .filter(word -> ONLY_CHARACTERS.matcher(word).matches() && !stopWords.contains(word))
                .collect(Collectors.toList());

        Set<String> uniqueWords = new HashSet<>(matchedWords);
        return new WordCounterResult(matchedWords.size(), uniqueWords.size());
    }
}
