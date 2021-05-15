package com.akhvatov.words.filter;

import com.akhvatov.words.State;

/**
 * Filters each word
 */
public interface Filter {

    boolean test(String word, State state);
}
