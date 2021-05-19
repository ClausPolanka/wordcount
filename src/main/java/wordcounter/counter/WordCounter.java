package wordcounter.counter;

import wordcounter.reader.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounter {

    private String text;
    private List<String> stopWords;

    public void setText(String text) {
        this.text = text;
    }

    public void setStopWords(FileReader fileReader) {
        stopWords = fileReader.getContent();
    }

    public int countWords() {
        String[] candidates = text.trim().split(" ");
        List<String> result = Arrays.stream(candidates)
                .filter(w -> w.matches("[a-zA-Z]+") && !stopWords.contains(w))
                .collect(Collectors.toList());
        return result.size();
    }
}
