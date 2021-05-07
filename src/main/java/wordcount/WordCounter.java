package wordcount;

import java.util.Arrays;

public class WordCounter {
    private final WordCounterOptions options;

    public WordCounter(WordCounterOptions options) {
        this.options = options;
    }

    public long count(String inputString) {
        String[] possibleWords =inputString.split(options.getWordSplitRegex());
        return Arrays.stream(possibleWords)
                .filter(w -> w.matches(options.getIsAWordRegex()))
                .filter(w -> !options.getStopWords().contains(w))
                .count();
    }
}
