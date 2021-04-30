package wordcount.counter.delimiter;

/**
 * SentenceSplitter splits sentence in words.
 */
public interface SentenceSplitter {

    /**
     * splits given string in array of strings
     * @param sentence - string to split
     * @return array of strings
     */
    String [] splitSentence(String sentence);

}
