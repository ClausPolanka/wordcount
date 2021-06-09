package root.wordcounter;

import java.util.Objects;

public class CountingResult {

    private final long numOfWords;
    private final long numUniqueWords;
    private final double averageWordLen;

    public CountingResult(long numOfWords, long numUniqueWords, double averageWordLen) {
        this.numOfWords = numOfWords;
        this.numUniqueWords = numUniqueWords;
        this.averageWordLen = averageWordLen;
    }

    public long getNumOfWords() {
        return numOfWords;
    }

    public long getNumUniqueWords() {
        return numUniqueWords;
    }

    public double getAverageWordLen() {
        return averageWordLen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountingResult result = (CountingResult) o;
        return numOfWords == result.numOfWords &&
                numUniqueWords == result.numUniqueWords &&
                Double.compare(result.averageWordLen, averageWordLen) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOfWords, numUniqueWords, averageWordLen);
    }

    @Override
    public String toString() {
        return "numOfWords: " + this.numOfWords + ", unique: " + this.numUniqueWords + ", avg: " + this.averageWordLen;
    }
}
