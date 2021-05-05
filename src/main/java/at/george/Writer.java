package at.george;

public interface Writer {

    /**
     * Writes the count and the unique count to an User Interface
     *
     * @param count       The count to be written to an User Interface, must not be negative
     * @param uniqueCount The count of unique words to be written to an User Interface, must not be negative
     */
    void write(long count, long uniqueCount);
}
