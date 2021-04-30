package wordcount.counter;

import wordcount.counter.delimiter.RegexSentenceSplitter;
import wordcount.counter.delimiter.SentenceSplitter;
import wordcount.counter.matcher.RegexWordMatcher;
import wordcount.counter.matcher.WordMatcher;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SimpleWordCounter implementation of WordCounter. Counts the words in given sentence
 */
public class SimpleWordCounter implements WordCounter {

    private final SentenceSplitter sentenceSplitter;
    private final WordMatcher wordMatcher;

    /**
     * Default constructor. RegexSentenceSplitter for splitting and RegexWordMatcher for checking words will be used
     */
    public SimpleWordCounter() {
        this(new RegexSentenceSplitter(), new RegexWordMatcher());
    }

    /**
     * Constructs SimpleWordCounter with given SentenceSplitter and WordMatcher.
     * sentenceSplitter and wordMatcher should not be null
     */
    public SimpleWordCounter(SentenceSplitter sentenceSplitter, WordMatcher wordMatcher) {
        if (sentenceSplitter == null || wordMatcher == null) {
            throw new IllegalArgumentException("Sentence splitter and word matcher should not be null!");
        }
        this.sentenceSplitter = sentenceSplitter;
        this.wordMatcher = wordMatcher;
    }

    /**
     * calculates number of words in a sentence
     * @param input - sentence
     * @return number of words
     */
    @Override
    public int countWords(String input) {
        if (input == null) {
            return 0;
        }
        String[] split = sentenceSplitter.splitSentence(input);
        List<String> matchedWords = Arrays.stream(split).filter(wordMatcher::isWordMatch)
                .collect(Collectors.toList());
        return matchedWords.size();
    }

}
