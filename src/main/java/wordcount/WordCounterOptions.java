package wordcount;

import java.util.HashSet;
import java.util.Set;

public class WordCounterOptions {
    private String isAWordRegex = "[a-zA-Z]+";
    private String wordSplitRegex = "[\\s\\-]+";
    private Set<String> stopWords = new HashSet<>();

    public String getIsAWordRegex() {
        return isAWordRegex;
    }

    public void setIsAWordRegex(String isAWordRegex) {
        this.isAWordRegex = isAWordRegex;
    }

    public String getWordSplitRegex() {
        return wordSplitRegex;
    }

    public void setWordSplitRegex(String wordSplitRegex) {
        this.wordSplitRegex = wordSplitRegex;
    }

    public Set<String> getStopWords() {
        return stopWords;
    }

    public void setStopWords(Set<String> stopWords) {
        this.stopWords = stopWords;
    }
}
