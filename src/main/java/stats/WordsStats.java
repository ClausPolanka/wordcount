package stats;

public class WordsStats {

    private final int wordCount;
    private final int uniqueWordCount;

    public WordsStats(int wordCount, int uniqueWordCount) {
        this.wordCount = wordCount;
        this.uniqueWordCount = uniqueWordCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getUniqueWordCount() {
        return uniqueWordCount;
    }
}
