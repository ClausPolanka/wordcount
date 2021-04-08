import java.util.List;
import java.util.logging.Logger;

public class WordCountService {

    private Logger LOGGER = Logger.getLogger(WordCountService.class.getName());

    private StopWordsHandler stopWordsHandler;

    public WordCountService(){
        stopWordsHandler = new StopWordsHandler();
    }

    public int count(List<String> words) throws IllegalArgumentException{
        if(words == null){
            LOGGER.warning("No words present to count.");
            throw new IllegalArgumentException("words not count are missing");
        }
        return getCountableWords(words);
    }

    private int getCountableWords(List<String> splitWords) {
        int numWords = 0;

        for(String word: splitWords){
            if(isValid(word.trim())){
                numWords++;
            }
        }

        return  numWords;
    }

    private boolean isValid(String word){
        return word != null && !word.isEmpty() && !stopWordsHandler.isStopword(word);
    }
}
