package at.george.counter;

import at.george.Counter;

import java.util.Arrays;

import static at.george.WordCountConstants.MATCH_LETTERS_REGEX;
import static at.george.WordCountConstants.SPLIT_SYMBOL;

public class TextSequenceCounter implements Counter {

    /**
     * Counts the number of words in a given line by treating chains of (a-z,A-Z)'s as words
     *
     * @param line The line to be processed, must not be null
     * @return The number of words counted
     */
    @Override
    public long count(String line) {
        return Arrays.stream(line.split(SPLIT_SYMBOL))
                .map(String::trim)
                .filter(word -> MATCH_LETTERS_REGEX.matcher(word).matches())
                .count();
    }
}
