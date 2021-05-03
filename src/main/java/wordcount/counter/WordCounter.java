package wordcount.counter;

import java.util.List;

/**
 * WordCounter interface calculates how many words are in a sentence
 */
public interface WordCounter {

    /**
     * calculates how many words are in a sentence
     * @param input - sentence
     * @return words count
     */
    int countWords(List<String> input);

}
