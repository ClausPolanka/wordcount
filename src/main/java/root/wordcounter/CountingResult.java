package root.wordcounter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountingResult result = (CountingResult) o;
        return numOfWords == result.numOfWords &&
                numUniqueWords == result.numUniqueWords;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOfWords, numUniqueWords);
    }

    @Override
    public String toString() {
        return "numOfWords: " + this.numOfWords + ", unique: " + this.numUniqueWords;
    }
}
