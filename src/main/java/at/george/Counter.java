package at.george;

public interface Counter {

    /**
     * Counts the number of words in a given line
     *
     * @param line The line to be processed, must not be null
     * @return The number of words counted
     */
    long count(String line);
}
