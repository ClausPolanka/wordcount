package com.akhvatov.words.aggregator;

import com.akhvatov.words.State;

public class PeekAggregator implements Aggregator {

    @Override
    public void aggregate(String word, State state) {
        System.out.println(word);
    }
}
