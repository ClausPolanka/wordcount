package wordcount;

public class WordCounterOutput {
    private long wordCount;
    private long uniqueCount;

    public long getWordCount() {
        return wordCount;
    }

    public WordCounterOutput setWordCount(long wordCount) {
        this.wordCount = wordCount;
        return this;
    }

    public long getUniqueCount() {
        return uniqueCount;
    }

    public WordCounterOutput setUniqueCount(long uniqueCount) {
        this.uniqueCount = uniqueCount;
        return this;
    }
}
