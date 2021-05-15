package com.akhvatov.words;

import com.akhvatov.words.aggregator.WordCountAggregator;
import com.akhvatov.words.filter.StopWordsFilter;
import com.akhvatov.words.filter.WordFilter;
import com.akhvatov.words.modifier.WordCleaner;
import com.akhvatov.words.source.ConsoleSource;
import com.akhvatov.words.source.FileStreamProvider;

import java.util.Arrays;

public class WordCountApp {

    public static void main(String[] args) {
        final WordsProcessor wordsProcessor = new WordsProcessor(Arrays.asList(
                new WordCleaner()
        ), Arrays.asList(
                new WordFilter(),
                new StopWordsFilter(FileStreamProvider.from("/stopwords.txt"))
        ), Arrays.asList(
                new WordCountAggregator()
                //new PeekAggregator()
        ));
        final State countState = wordsProcessor.count(new ConsoleSource());
        System.out.println(countState.describe());
    }
}
