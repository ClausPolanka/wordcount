package com.wordcount.counter;

import com.wordcount.dto.CounterDto;
import com.wordcount.filter.StopwordFilter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CounterImpl implements Counter{

    private StopwordFilter stopwordFilter;

    public CounterImpl(StopwordFilter stopwordFilter) {
        this.stopwordFilter = stopwordFilter;
    }

    public CounterDto countWords(String text) {
        //Splits the input using a space character as delimiter and removes any empty strings
        String[] splittedString = text.split(" ");
        Stream<String> wordStream = Arrays.stream(splittedString)
                .filter(s -> !s.isEmpty());

        List<String> wordList = stopwordFilter.removeStopwords(wordStream.collect(Collectors.toList()));

        long numberOfWords = wordList.stream()
                .filter(this::containsOnlyLetters).count();


        CounterDto counterDto = new CounterDto(1L, 1L);

        return counterDto;
    }

    private long getNumberOfWords() {
        return 0;
    }

    private long getNumberOfUniqueWords() {
        return 0;
    }

    private boolean containsOnlyLetters(String word) {
        return word.chars().allMatch(Character::isLetter);
    }

}
