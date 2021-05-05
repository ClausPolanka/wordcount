package sk.sloboda.wordcount.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class WordCount {

    private int count = 0;
    private int uniqueCount = 0;
    private Double averageLength = 0.0;
    private List<String> words;

    public WordCount() {
    }

    public WordCount(int count, int uniqueCount, List<String> words) {
        this.count = count;
        this.uniqueCount = uniqueCount;
        this.words = words;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUniqueCount() {
        return uniqueCount;
    }

    public void setUniqueCount(int uniqueCount) {
        this.uniqueCount = uniqueCount;
    }

    public Double getAverageLength() {
        return averageLength;
    }

    public void setAndRoundAverageLength(Double averageLength) {
        if (averageLength != null) {
            DecimalFormat formatter = new DecimalFormat("#.##");
            this.averageLength = Double.valueOf(formatter.format(averageLength));
        } else {
            this.averageLength = averageLength;
        }
    }

    public List<String> getSortedWords() {
        if (words == null || words.isEmpty())
            return new ArrayList<>();

        words.sort(String.CASE_INSENSITIVE_ORDER);
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
