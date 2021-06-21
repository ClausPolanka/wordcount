package wordcount.domain;

import java.util.List;

public interface IWordCounter {

    WordCounter.CountResult countWords(String textToCount, List<String> stopwordList);

}
