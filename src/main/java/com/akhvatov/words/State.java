package com.akhvatov.words;

/**
 * Internal state of each count execution. Contains all required counters/collections/etc.
 */
public class State {

    private long count;

    public void incrementCounter() {
        count++;
    }

    public long getCount() {
        return count;
    }

    public String describe() {
        return String.format("Number of words: %d", count);
    }
}
