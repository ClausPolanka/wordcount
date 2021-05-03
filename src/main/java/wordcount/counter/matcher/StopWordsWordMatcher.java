package wordcount.counter.matcher;

import java.util.List;
import java.util.stream.Collectors;

/**
 * StopWordsWordMatcher checks if word matches is not in a defined stop words list
 */
public class StopWordsWordMatcher implements WordMatcher {

    private final List<String> stopWords;

    /**
     * constructor with stopWords, which should be used fro checks.
     * defined stopWords should match pattern in a given regexWordMatcher
     */
    public StopWordsWordMatcher(List<String> stopWords, RegexWordMatcher regexWordMatcher) {
        this.stopWords = stopWords;
        validateStopWords(regexWordMatcher);
    }

    private void validateStopWords(RegexWordMatcher regexWordMatcher) {
        List<String> notMatchedStopWords =
                stopWords.stream().filter(stopWord -> !regexWordMatcher.isWordMatch(stopWord))
                        .collect(Collectors.toList());
        if (!notMatchedStopWords.isEmpty()) {
            throw new IllegalArgumentException("Some stop words are not valid! " + notMatchedStopWords);
        }
    }

    /**
     * checks if word is in the stopWords list
     * @param word - string to check
     * @return true, if word is not in the stopWords list
     */
    @Override
    public boolean isWordMatch(String word) {
        return !stopWords.contains(word);
    }
}
