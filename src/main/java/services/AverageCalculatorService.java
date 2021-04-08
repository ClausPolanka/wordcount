package services;

import java.util.ArrayList;
import java.util.List;

public class AverageCalculatorService {

    private StopWordsHandlerService stopWordsHandlerService;

    public AverageCalculatorService(){
        stopWordsHandlerService = new StopWordsHandlerService();
    }

    public double getAverageOfCharacters(List<String> words){
        List<Double> listOfCharacterCounts = getAmountOfCharacters(words);
        return calculateAverageFromCounts(listOfCharacterCounts);
    }

    private double calculateAverageFromCounts(List<Double> listOfCharacterCounts) {
        double sum = getSumOfCounts(listOfCharacterCounts);
        return sum/listOfCharacterCounts.size();
    }

    private double getSumOfCounts(List<Double> listOfCharacterCounts) {
        double sum = 0;
        for(Double count: listOfCharacterCounts){
            sum += count;
        }
        return sum;
    }

    private List<Double>  getAmountOfCharacters(List<String> words) {
        List<Double> characterCounts = new ArrayList<>();
        for(String word: words){
            if(!stopWordsHandlerService.isStopword(word)) {
                characterCounts.add((double) word.length());
            }
        }
        return characterCounts;
    }
}
