package wordcounter;

import java.util.List;

public interface WordCounter {
    Integer computeTotalWordsNumber();

    Integer computeUniqueWordsNumber();

    Double computeWordLengthAverage();

    List<String> retrieveWordsSorted();
}
