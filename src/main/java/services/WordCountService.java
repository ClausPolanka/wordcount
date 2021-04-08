package services;

import entities.WordCountResult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class WordCountService {

    private Logger LOGGER = Logger.getLogger(WordCountService.class.getName());

    private StopWordsHandlerService stopWordsHandlerService;

    public WordCountService(){
        stopWordsHandlerService = new StopWordsHandlerService();
    }

    public WordCountResult count(List<String> words) throws IllegalArgumentException{
        if(words == null){
            LOGGER.warning("No words present to count.");
            throw new IllegalArgumentException("words not count are missing");
        }

        int amountCountableWords = getAmountOfCountableWords(words);
        int amountUniqueWords = getAmountOfUniqueWords(words);
        double averageWordLength = getAverageWordLength(words);

        return new WordCountResult(amountCountableWords, amountUniqueWords, averageWordLength);
    }


    private int getAmountOfCountableWords(List<String> splitWords) {
        int numWords = 0;

        for(String word: splitWords){
            if(isValid(word.trim())){
                numWords++;
            }
        }
        return  numWords;
    }

    private int getAmountOfUniqueWords(List<String> splitWords) {
        Set<String> uniqueWords = new HashSet<>();

        for(String word: splitWords){
            if(isValid(word.trim())){
                uniqueWords.add(word);
            }
        }
        return uniqueWords.size();
    }

    private double getAverageWordLength(List<String> words) {
        return new AverageCalculatorService().getAverageOfCharacters(words);
    }

    private boolean isValid(String word){
        return word != null && !word.isEmpty() && !stopWordsHandlerService.isStopword(word);
    }
}
