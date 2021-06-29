public class WordCount {

    private static final String WORD_REGEX = "[a-zA-Z]+";

    public int getNumberOfWords(String text){

        if (text == null || text.isEmpty()){
            return 0;
        }

        int count = 0;

        for (String w : text.split(" ")){
            if (isWord(w)) count++;
        }

        return count;
    }

    private boolean isWord(String word){
        return word.matches(WORD_REGEX);
    }
}