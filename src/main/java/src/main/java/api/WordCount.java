package src.main.java.api;

public interface WordCount {
    /**
     * Count the number of words from a given text.
     * @param text
     * @return number of words
     */
    int countWords(String text);

    /**
     * Counts the number of words from a given text and eliminates those that are considered "stop words"
     * @param text
     * @return
     */
    int countWordsWithStopper(String text);

    /**
     * Countes the number of unique words from a given text.
     * @param text
     * @return
     */
    int countUniqueWords(String text);

    /**
     * Returns the average word length from a given text.
     * @param text
     * @return
     */
    double getWordAvgLength(String text);
}
