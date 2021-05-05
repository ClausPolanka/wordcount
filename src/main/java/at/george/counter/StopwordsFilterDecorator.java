package at.george.counter;

import at.george.Counter;
import at.george.StopwordsProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static at.george.WordCountConstants.SPLIT_SYMBOL;

public class StopwordsFilterDecorator implements Counter {

    private final Counter delegate;
    private final StopwordsProvider stopwordsProvider;

    public StopwordsFilterDecorator(Counter delegate, StopwordsProvider stopwordsProvider) {
        this.delegate = delegate;
        this.stopwordsProvider = stopwordsProvider;
    }

    /**
     * Counts the number of words in a given line by delegating the counting process to delegate and filtering
     * stopwords beforehand
     *
     * @param line The line to be processed, must not be null
     * @return The number of words counted
     */
    @Override
    public long count(String line) {
        List<String> stopwords = stopwordsProvider.retrieveStopwords();
        List<String> stopwordsTrimmed = normalizeStopwords(stopwords);
        line = filterStopwords(line, stopwordsTrimmed);

        return delegate.count(line);
    }

    private List<String> normalizeStopwords(List<String> stopwords) {
        return stopwords.stream()
                .map(this::normalize)
                .collect(Collectors.toList());
    }

    private String filterStopwords(String line, final List<String> stopwords) {
        return Arrays.stream(line.split(SPLIT_SYMBOL))
                .filter(word -> !stopwords.contains(normalize(word)))
                .collect(Collectors.joining(SPLIT_SYMBOL));
    }

    private String normalize(String word) {
        return word.trim().toLowerCase();
    }
}
