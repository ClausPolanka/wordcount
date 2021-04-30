package wordcount.counter;

/**
 * WordCounter interface calculates how many words are in a sentence
 */
public interface WordCounter {

    /**
     * calculates how many words are in a sentence
     * @param input - sentence
     * @return words count
     */
    int countWords(String input);

}
