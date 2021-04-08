public class WordCountService {

    private static final String PATTNER_SPACE = "\\s";
    private static final String PATTERN_LETTERS = "([ ]*[A-Za-z]+[ ]*)+";

    public int count(String words){
        if(isValidWords(words)){
            return splitWords(words).length;

        } else {
            return 0;
        }
    }

    private String[] splitWords(String words){
        return words.split(PATTNER_SPACE);
    }

    private boolean isValidWords(String words){
       return words.matches(PATTERN_LETTERS);
    }
}
