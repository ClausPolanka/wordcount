package wordcount.counter.matcher;

/**
 * checks if a word matches some rules
 */
public interface WordMatcher {

    /**
     * checks if string matches a rule
     * @param word - string to check
     * @return boolean which says if word matches defined rules
     */
    boolean isWordMatch(String word);

}
