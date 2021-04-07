package com.wordcount.counter;

import com.wordcount.dto.CounterDto;
import com.wordcount.filter.StopwordFilter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CounterImpl implements Counter{

    private final StopwordFilter stopwordFilter;

    public CounterImpl(StopwordFilter stopwordFilter) {
        this.stopwordFilter = stopwordFilter;
    }

    public CounterDto countWords(String text) {
        String[] splittedString = text.split(" ");
        Stream<String> wordStream = Arrays.stream(splittedString).filter(s -> !s.isEmpty());

        List<String> wordList = stopwordFilter.removeStopwords(wordStream.collect(Collectors.toList()));
        long numberOfWords = getNumberOfWords(wordList);
        long numberOfUniqueWords = getNumberOfUniqueWords(wordList);

        return new CounterDto(numberOfWords, numberOfUniqueWords);
    }

    private long getNumberOfWords(List<String> wordList) {
        return wordList.stream()
                .filter(this::isWord)
                .count();
    }

    private long getNumberOfUniqueWords(List<String> wordList) {
        return wordList.stream()
                .filter(this::isWord)
                .distinct()
                .count();
    }

    /**
     * Check if the input is a valid word according to following rules:
     * Words are stretches of letters (a-z,A-Z)
     * Words can contain a hyphen
     * Words can end with a dot
     */
    private boolean isWord(String word) {
        return word.matches("[a-zA-Z]+\\.?") || word.matches("[a-zA-Z]+-[a-zA-Z]+\\.?");
    }

}
