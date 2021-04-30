package wordcounter;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

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

    @Override
    public Double computeWordLengthAverage() {
        DecimalFormat format = new DecimalFormat("#.##");
        Double wordLengthAverage = words.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);

        return Double.valueOf(format.format(wordLengthAverage));
    }

    @Override
    public List<String> retrieveWordsSorted() {
        return words.stream()
                .sorted()
                .collect(toList());
    }
}
