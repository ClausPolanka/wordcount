package wordcount.domain;

import java.util.Arrays;
import java.util.List;

public class WordCounter {

    public static final String WHITESPACES = "\\s+";

    private final List<String> stopWords;

    public WordCounter(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public long count(String text) {
        if (text != null) {
            String[] words = splitByWhiteSpaces(text);

            return countLegalWords(words);
        }
        return 0;
    }

    private long countLegalWords(String[] words) {
        return Arrays.stream(words)
                .filter(this::shouldCount)
                .filter(this::isLegal)
                .count();
    }

    private boolean shouldCount(String word) {
        return !stopWords.contains(word);
    }

    private boolean isLegal(String word) {
        return word.matches("[a-zA-Z]+");
    }

    private String[] splitByWhiteSpaces(String text) {
        return text.split(WHITESPACES);
    }
}
