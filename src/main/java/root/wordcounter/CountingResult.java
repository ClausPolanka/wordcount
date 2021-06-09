package root.wordcounter;

public class CountingResult {

    private long numOfWords;
    private long numUniqueWords;

    public CountingResult(long numOfWords, long numUniqueWords) {
        this.numOfWords = numOfWords;
        this.numUniqueWords = numUniqueWords;
    }

    public long getNumOfWords() {
        return numOfWords;
    }

    public long getNumUniqueWords() {
        return numUniqueWords;
    }
}
