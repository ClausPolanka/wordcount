package wordcount;

import java.util.Set;

public class WordCounterOptions {
    /**
     * Stop words are a set of words
     * which should be not included in any calculation
     * withing {@link WordCounter}
     */
    private final Set<String> stopWords;

    public WordCounterOptions(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    public Set<String> getStopWords() {
        return stopWords;
    }
}
