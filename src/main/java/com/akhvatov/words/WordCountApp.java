package com.akhvatov.words;

import com.akhvatov.words.aggregator.WordCountAggregator;
import com.akhvatov.words.filter.StopWordsFilter;
import com.akhvatov.words.filter.WordFilter;
import com.akhvatov.words.modifier.WordCleaner;
import com.akhvatov.words.source.ConsoleSource;
import com.akhvatov.words.source.FileStreamProvider;

import java.util.Arrays;
import java.util.Collections;

public class WordCountApp {

    public static void main(String[] args) {
        final WordsProcessor wordsProcessor = new WordsProcessor(Collections.singletonList(
                new WordCleaner()
        ), Arrays.asList(
                new WordFilter(),
                new StopWordsFilter(FileStreamProvider.from("/stopwords.txt"))
        ), Collections.singletonList(
                new WordCountAggregator()
        ));
        final State countState = wordsProcessor.count(new ConsoleSource());
        System.out.println(countState.describe());
    }
}
