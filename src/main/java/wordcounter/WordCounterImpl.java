package wordcounter;

import java.util.List;

public class WordCounterImpl implements WordCounter {

    private List<String> words;

    public WordCounterImpl(List<String> words) {
        this.words = words;
    }

    @Override
    public Integer computeTotalWordsNumber() {
        return words.size();
    }
}
