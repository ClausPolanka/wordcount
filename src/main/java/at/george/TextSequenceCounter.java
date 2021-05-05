package at.george;

import java.util.Arrays;

public class TextSequenceCounter implements Processor {

    private final String splitSymbol = " ";
    private final String matchLettersRegex = "[a-zA-Z]+";

    /**
     * Counts the number of words in a given line by treating chains of (a-z,A-Z)'s as words
     *
     * @param line The line to be processed, must not be null
     * @return The number of words counted
     */
    @Override
    public long process(String line) {
        return Arrays.stream(line.split(splitSymbol))
                .map(String::trim)
                .filter(word -> word.matches(matchLettersRegex))
                .count();
    }
}
