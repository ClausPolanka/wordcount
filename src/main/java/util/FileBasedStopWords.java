package util;

import java.util.List;

public class FileBasedStopWords implements StopWords {

    List<String> stopWords = FileReader.getWordsFromFile("stopwords.txt");

    @Override
    public boolean contains(String word) {
        return stopWords.contains(word);
    }
}
