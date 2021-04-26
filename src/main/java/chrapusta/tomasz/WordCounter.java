package chrapusta.tomasz;

import java.util.Arrays;

public class WordCounter {

    private final String separator;

    public WordCounter(String separator) {
        this.separator = separator;
    }

    public long countWords(final String input) {
        validateString(input);

        String separated = input.replaceAll("\\s+", this.separator);

        return Arrays.stream(separated.split(this.separator))
                .filter(s -> s.matches("[a-zA-Z]+"))
                .count();
    }

    private void validateString(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Provided String must not be null!");
        }
    }
}
