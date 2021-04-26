package chrapusta.tomasz;

import java.util.Arrays;
import java.util.Set;

public class WordCounter {

    private final String separator;
    private final Set<String> stopWords;

    public WordCounter(String separator, Set<String> stopWords) {
        this.separator = separator;
        this.stopWords = stopWords;
    }

    public long countWords(final String input) {
        validateString(input);

        String separated = separate(this.separator, input);

        return Arrays.stream(separated.split(this.separator))
                .filter(this::checkWord)
                .count();
    }

    private boolean checkWord(String word) {
        if (stopWords.contains(word)){
            return false;
        }
        return (word.matches("[a-zA-Z]+"));
    }

    private String separate(final String separator, final String input) {
        return input.replaceAll("\\s+", separator);
    }

    private void validateString(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Provided String must not be null!");
        }
    }
}
