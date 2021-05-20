package Controller;

import Controller.Interfaces.IOWorker;
import Controller.Interfaces.View;
import Model.Word;

import java.util.ArrayList;
import java.util.List;

public class WordCounter {

    private static String spaceSeparator = " ";

    private final View counterView;
    private final IOWorker ioWorker;

    public List<Word> listOfWords;

    public WordCounter(View counterView, IOWorker ioWorker) {
        this.counterView = counterView;
        this.ioWorker = ioWorker;
        listOfWords = new ArrayList<>();

    }

    public void countWords() {
        counterView.updateView("Please give words to count!");
        try {
            this.parseInputToStrings(ioWorker.readFromConsole());
        } catch (Exception exc) {
            counterView.updateView("There was an error, while parsing input. \n" + "Error massage: " + exc);
        }
        counterView.updateView("Number of words: " + this.listOfWords.size());
    }

    private void parseInputToStrings(List<String> inputResult) {
        if (inputResult.isEmpty()) {
            counterView.updateView("The given input was blank!");
        }

        for (String line : inputResult) {
            String[] possibleWords = line.split(spaceSeparator);
            this.addStringsToWords(possibleWords);
        }
    }

    private void addStringsToWords(String[] possibleWords){
        for (String possibleWord:
             possibleWords) {
            if (possibleWord.matches("[a-z,A-Z]+")) {
                Word word = new Word();
                word.setWord(possibleWord);
                listOfWords.add(word);
            }
        }
    }
}
