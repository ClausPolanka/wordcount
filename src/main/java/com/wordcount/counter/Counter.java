package com.wordcount.counter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Counter {

    private StopwordFilter stopwordFilter = new StopwordFilter();

    public void setStopwordFilter(StopwordFilter stopwordFilter) {
        this.stopwordFilter = stopwordFilter;
    }

    public long countWords(String words) {
        String[] splittedString = words.split(" ");
        Stream<String> wordStream = Arrays.stream(splittedString)
                .filter(s -> !s.isEmpty());

        List<String> wordList = stopwordFilter.removeStopwords(wordStream.collect(Collectors.toList()));

        return wordList.stream()
                .filter(this::containsOnlyLetters).count();
    }

    private boolean containsOnlyLetters(String word) {
        return word.chars().allMatch(Character::isLetter);
    }

}
