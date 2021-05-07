package wordcount;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCounter {
    private final WordCounterOptions options;

    public WordCounter(WordCounterOptions options) {
        this.options = options;
    }

    public WordCounterOutput count(String inputString) {
        List<String> possibleWords = Arrays.asList(inputString.split(options.getWordSplitRegex()));

        List<String> matchedWords = possibleWords.stream()
                .filter(w -> w.matches(options.getIsAWordRegex()))
                .filter(w -> !options.getStopWords().contains(w))
                .collect(Collectors.toList());

        long wordCount = matchedWords.size();
        Set<String> uniqueWords = new HashSet<>(matchedWords);

        return new WordCounterOutput()
                .setUniqueCount(uniqueWords.size())
                .setWordCount(wordCount);
    }
}
