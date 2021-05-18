package com.akhvatov.words;

import com.akhvatov.words.aggregator.WordCountAggregator;
import com.akhvatov.words.filter.WordFilter;
import com.akhvatov.words.modifier.WordCleaner;
import com.akhvatov.words.source.ConsoleSource;

import java.util.Collections;

public class WordCountApp {

    public static void main(String[] args) {
        final WordsProcessor wordsProcessor = new WordsProcessor(Collections.singletonList(
                new WordCleaner()
        ), Collections.singletonList(
                new WordFilter()
        ), Collections.singletonList(
                new WordCountAggregator()
        ));
        final State countState = wordsProcessor.count(new ConsoleSource());
        System.out.println(countState.describe());
    }
}
