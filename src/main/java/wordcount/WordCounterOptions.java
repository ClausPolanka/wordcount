package wordcount;

import java.util.HashSet;
import java.util.Set;

public class WordCounterOptions {
    private Set<String> stopWords = new HashSet<>();

    public Set<String> getStopWords() {
        return stopWords;
    }

    public WordCounterOptions setStopWords(Set<String> stopWords) {
        this.stopWords = stopWords;
        return this;
    }
}
