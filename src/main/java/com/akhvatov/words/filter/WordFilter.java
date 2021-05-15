package com.akhvatov.words.filter;

import com.akhvatov.words.State;

import java.util.function.IntPredicate;

/**
 * Word Count I: Write an application to count the number of words in a text. The app will ask the user for the text upon start.
 * It will then output the number of words found in the text. Words are stretches of letters (a-z,A-Z)
 * Word Count V: Words containing a hyphen are no longer separated, e.g. „Humpty-Dumpty“ will be considered 1 word instead of 2.
 */
public class WordFilter implements Filter {

    @Override
    public boolean test(String word, State state) {
        if (word == null || word.trim().isEmpty()) {
            return false;
        }

        return word.chars().allMatch(isLetter.or(isHyphen));
    }

    private static final IntPredicate isLetter = Character::isLetter;
    private static final IntPredicate isHyphen = c -> c == '-';
}
