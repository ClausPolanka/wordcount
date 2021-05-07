package wordcount;

import java.util.Set;

public class WordCounterOptions {
    private final Set<String> stopWords;

    public WordCounterOptions(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    public Set<String> getStopWords() {
        return stopWords;
    }
}
