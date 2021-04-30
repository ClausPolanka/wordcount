package wordcounter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordCounterImpl implements WordCounter {

    private List<String> words;

    public WordCounterImpl(List<String> words) {
        this.words = words;
    }

    @Override
    public Integer computeTotalWordsNumber() {
        return words.size();
    }

    @Override
    public Integer computeUniqueWordsNumber() {
        Set<String> uniqueWords = new HashSet<>(words);
        return uniqueWords.size();
    }
}
