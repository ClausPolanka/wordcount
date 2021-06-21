package wordcount.domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter implements IWordCounter {

    @Override
    public long countWords(String textToCount) {
    String[] words =  textToCount.split("/\\s+");
    return Arrays.stream(words).filter(this::isValid).count();
    }

    public boolean isValid(String word) {
        Pattern p = Pattern.compile("^[a-zA-Z]+$");
        final Matcher matcher = p.matcher(word);
        return matcher.find();
    }

}
