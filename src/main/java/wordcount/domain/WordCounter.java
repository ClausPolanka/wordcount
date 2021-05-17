package wordcount.domain;

import java.util.Arrays;

public class WordCounter {

    public static final String WHITESPACES = "\\s+";

    public long count(String text) {
        if (text != null) {
            String[] words = splitByWhiteSpaces(text);

            return countLegalWords(words);
        }
        return 0;
    }

    private long countLegalWords(String[] words) {
        return Arrays.stream(words)
                .filter(this::isLegal)
                .count();
    }

    private boolean isLegal(String word) {
        return word.matches("[a-zA-Z]+");
    }

    private String[] splitByWhiteSpaces(String text) {
        return text.split(WHITESPACES);
    }
}
