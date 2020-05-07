import java.util.Arrays;

import word.match.WordMatcher;

public class WordCounterImpl implements WordCounter {

    private final WordMatcher wordMatcher;

    public WordCounterImpl(WordMatcher wordMatcher) {
        this.wordMatcher = wordMatcher;
    }

    @Override
    public long count(String text) {
        if (text == null) {
            return 0;
        }

        String[] splitText = text.split("\\s+");
        return Arrays.stream(splitText)
                .filter(this::isNotBlank)
                .filter(wordMatcher::match)
                .count();
    }

    private boolean isNotBlank(String str) {
        return !str.isEmpty() && !str.matches("\\s+");
    }
}