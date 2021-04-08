public class WordCountService {

    private static final String PATTNER_SPACE = "\\s"; //pattern of a whitespace
    private static final String PATTERN_LETTERS = "([ ]*[A-Za-z]+[ ]*)+"; //pattern indicating if a letter is contained

    public int count(String words){
        if(!isValidWordString(words)){
            return 0;
        }

        return getCountableWords(splitWords(words));
    }

    private int getCountableWords(String[] splitWords) {
        int numWords = 0;
        StopWordsHandler stopWordsHandler = new StopWordsHandler();

        for(String word: splitWords){
            if(!stopWordsHandler.isStopword(word)){
                numWords++;
            }
        }

        return  numWords;
    }

    private String[] splitWords(String words){
        return words.split(PATTNER_SPACE);
    }

    private boolean isValidWordString(String words){
        return words.matches(PATTERN_LETTERS);
    }
}
