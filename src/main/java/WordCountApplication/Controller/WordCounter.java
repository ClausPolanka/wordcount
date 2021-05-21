package WordCountApplication.Controller;

import WordCountApplication.Controller.Interfaces.IOWorker;
import WordCountApplication.Controller.Interfaces.View;
import WordCountApplication.Model.Word;

import java.util.ArrayList;
import java.util.List;

public class WordCounter {

    private static String stopWordsFileName = "stop_words.txt";
    private static String spaceSeparator = " ";
    private final View counterView;
    private final IOWorker ioWorker;
    private List<String> stopWords;
    private List<String> stringOfFile;

    public List<Word> listOfWords;

    public WordCounter(View counterView, IOWorker ioWorker) {
        this.counterView = counterView;
        this.ioWorker = ioWorker;
        listOfWords = new ArrayList<>();
    }

    public void countWords() {
        try {
            stopWords = ioWorker.fileReader(stopWordsFileName);

            counterView.updateView("Please add the name of a file to count the words of the file! (Press enter to skip it)");
            String fileName = ioWorker.singleLineReader();
            stringOfFile = ioWorker.fileReader(fileName);

            if(stringOfFile.isEmpty()){
                counterView.updateView("Please give words to count (Press enter(s) to start the counting):");
                this.parseInputToStrings(ioWorker.readFromConsole());
            } else {
                parseInputToStrings(stringOfFile);
            }
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

    private void addStringsToWords(String[] possibleWords) {
        for (String possibleWord :
                possibleWords) {
            if (isWordMatch(possibleWord,"[a-z,A-Z]+") && !isStopWord(possibleWord)) {
                Word word = new Word();
                word.setWord(possibleWord);
                listOfWords.add(word);
            }
        }
    }

    private boolean isWordMatch(String word, String regEx) {
        if (word.matches(regEx)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isStopWord(String word) {
        if(stopWords.contains(word)){
            return true;
        } else {
            return false;
        }
    }
}
