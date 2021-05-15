package com.akhvatov.words.modifier;

import com.akhvatov.words.State;

/**
 * Modified each word: can be used to clean or to separate if necessary
 */
public interface Modifier {

    String apply(String word, State state);
}
