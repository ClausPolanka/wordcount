package com.akhvatov.words.modifier;

import com.akhvatov.words.State;

/**
 * Removes . (dot) from the word
 */
public class WordCleaner implements Modifier {

    @Override
    public String apply(String word, State state) {
        return word.replace(".", "");
    }
}
