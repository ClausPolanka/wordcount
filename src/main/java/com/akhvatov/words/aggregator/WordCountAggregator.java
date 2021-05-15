package com.akhvatov.words.aggregator;

import com.akhvatov.words.State;

public class WordCountAggregator implements Aggregator {

    @Override
    public void aggregate(String word, State state) {
        state.incrementCounter();
    }
}
