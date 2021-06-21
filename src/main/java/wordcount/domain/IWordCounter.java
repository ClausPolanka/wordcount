package wordcount.domain;

import java.util.List;

public interface IWordCounter {

    long countWords(String textToCount, List<String> stopwordList);

}
