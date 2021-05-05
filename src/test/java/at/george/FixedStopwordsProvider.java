package at.george;

import java.util.ArrayList;
import java.util.List;

public class FixedStopwordsProvider implements StopwordsProvider {

    @Override
    public List<String> retrieveStopwords() {
        List<String> stopwords = new ArrayList<>();
        stopwords.add("the");
        stopwords.add("a");
        stopwords.add("i");
        return stopwords;
    }
}
