package services;

import exceptions.NotValidWordStringException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordSplitService {

    private static final String PATTNER_SPACE = "\\s"; //pattern of a whitespace or hyphen
    private static final String PATTERN_LETTERS = "[A-Za-z]"; //pattern indicating if a letter is contained

    public List<String> splitWordsFromString(String wordString) throws NotValidWordStringException {
        if(!isValidWordString(wordString)){
            throw new NotValidWordStringException("Given word string is not valid: "+wordString);
        } else {
            return splitWords(wordString);
        }
    }

    private List<String> splitWords(String wordString){
        String wordStringWithoutDotCommaAndSemicolon = wordString.replace(".","").replace(",","").replace(";","");
        return Arrays.asList(wordStringWithoutDotCommaAndSemicolon.split(PATTNER_SPACE));
    }

    private boolean isValidWordString(String wordString){
        return Pattern.compile(PATTERN_LETTERS).matcher(wordString).find();
    }
}
