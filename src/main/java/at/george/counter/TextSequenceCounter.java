package at.george.counter;

import at.george.Counter;

import java.util.Arrays;
import java.util.stream.Stream;

import static at.george.WordCountConstants.*;

public class TextSequenceCounter implements Counter {

    /**
     * Counts the number of words in a given line by treating chains of (a-z,A-Z)'s as words
     *
     * @param line The line to be processed, must not be null
     * @return The number of words counted
     */
    @Override
    public long count(String line) {
        return preprocessLine(line)
                .count();
    }

    /**
     * Counts the number of unique words in a given line by treating chains of (a-z,A-Z)'s as words
     *
     * @param line The line to be processed, must not be null
     * @return The number of unique words counted
     */
    @Override
    public long countUnique(String line) {
        return preprocessLine(line)
                .distinct()
                .count();
    }

    private Stream<String> preprocessLine(String line) {
        return Arrays.stream(line.split(SPLIT_SYMBOL))
                .map(String::trim)
                .map(this::removeEndingDot)
                .flatMap(this::splitOnDash)
                .filter(word -> MATCH_LETTERS_REGEX.matcher(word).matches());
    }

    private String removeEndingDot(String word) {
        return word.endsWith(DOT) ? word.substring(0, word.length() - 1) : word;
    }

    private Stream<String> splitOnDash(String word) {
        return Arrays.stream(word.contains(DASH) ? word.split(DASH) : new String[]{word});
    }
}
