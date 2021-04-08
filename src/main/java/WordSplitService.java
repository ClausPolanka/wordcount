import java.util.Arrays;
import java.util.List;

public class WordSplitService {

    private static final String PATTNER_SPACE = "\\s"; //pattern of a whitespace
    private static final String PATTERN_LETTERS = "([ ]*[A-Za-z]+[ ]*)+"; //pattern indicating if a letter is contained

    public List<String> splitWordsFromString(String wordString){
        if(!isValidWordString(wordString)){
            return null;
        } else {
            return splitWords(wordString);
        }
    }

    private List<String> splitWords(String wordString){
        return Arrays.asList(wordString.split(PATTNER_SPACE));
    }

    private boolean isValidWordString(String wordString){
        return wordString.matches(PATTERN_LETTERS);
    }
}
