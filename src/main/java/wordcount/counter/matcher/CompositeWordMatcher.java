package wordcount.counter.matcher;

import java.util.List;

/**
 * Checks if word is matching all defined macthers
 */
public class CompositeWordMatcher implements WordMatcher {

    private final List<WordMatcher> wordMatchers;

    public CompositeWordMatcher(List<WordMatcher> wordMatchers) {
        this.wordMatchers = wordMatchers;
    }

    /**
     * checks if word macthes defined simple matchers
     * @param word - string to check
     * @return boolean, saying is all matchers are macthed
     */
    @Override
    public boolean isWordMatch(String word) {
        return wordMatchers.stream().map(matcher -> matcher.isWordMatch(word)).reduce(true, (a, b) -> a && b);
    }

}
