package wordcounter.counter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounter {

    // TODO
    private String text;
    private List<String> stopWords;

    public WordCounter(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int countWords() {
        String[] candidates = text.trim().split(" ");
        List<String> result = Arrays.stream(candidates)
                .filter(w -> w.matches("[a-zA-Z]+") && !stopWords.contains(w))
                .collect(Collectors.toList());
        return result.size();
    }
}
