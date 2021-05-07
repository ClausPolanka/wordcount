package wordcount;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class WordCounterOptions {
    // single full-stop at the end is not causing word to be ignored
    private Pattern isAWordRegex = Pattern.compile("([a-zA-Z]+(-)?[a-zA-Z+]+|[a-zA-Z]+)(\\.)?");
    private Pattern wordSplitRegex = Pattern.compile("[\\s]+");
    private Set<String> stopWords = new HashSet<>();

    public Pattern getIsAWordRegex() {
        return isAWordRegex;
    }

    public WordCounterOptions setIsAWordRegex(Pattern isAWordRegex) {
        this.isAWordRegex = isAWordRegex;
        return this;
    }

    public Pattern getWordSplitRegex() {
        return wordSplitRegex;
    }

    public WordCounterOptions setWordSplitRegex(Pattern wordSplitRegex) {
        this.wordSplitRegex = wordSplitRegex;
        return this;
    }

    public Set<String> getStopWords() {
        return stopWords;
    }

    public WordCounterOptions setStopWords(Set<String> stopWords) {
        this.stopWords = stopWords;
        return this;
    }
}
