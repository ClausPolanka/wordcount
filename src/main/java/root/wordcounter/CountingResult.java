package root.wordcounter;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CountingResult {

    private final long numOfWords;
    private final long numUniqueWords;
    private final double averageWordLen;
    private final List<String> index;

    public CountingResult(long numOfWords, long numUniqueWords, double averageWordLen, List<String> index) {
        this.numOfWords = numOfWords;
        this.numUniqueWords = numUniqueWords;
        this.averageWordLen = averageWordLen;
        this.index = index;
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

    public List<String> getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountingResult result = (CountingResult) o;
        return numOfWords == result.numOfWords &&
                numUniqueWords == result.numUniqueWords &&
                Double.compare(result.averageWordLen, averageWordLen) == 0 &&
                Objects.equals(index, result.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOfWords, numUniqueWords, averageWordLen, index);
    }

    @Override
    public String toString() {
        return "numOfWords: " + this.numOfWords + ", unique: " + this.numUniqueWords + ", avg: " + this.averageWordLen;
    }
}
