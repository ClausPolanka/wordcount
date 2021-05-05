package at.george;

import java.util.List;

public interface StopwordsProvider {

    /**
     * Retrieves the stopwords which should not be included in the counting process
     *
     * @return All stopwords
     */
    List<String> retrieveStopwords();
}
