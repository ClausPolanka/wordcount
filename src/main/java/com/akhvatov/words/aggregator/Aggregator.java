package com.akhvatov.words.aggregator;

import com.akhvatov.words.State;

/**
 * Aggregate each word: increase counters, calculate average, etc.
 * Also can be used for any other purpose, for example logging
 */
public interface Aggregator {

    void aggregate(String word, State state);
}
