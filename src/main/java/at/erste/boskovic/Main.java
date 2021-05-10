package at.erste.boskovic;

import at.erste.boskovic.implementation.RegexWordCounter;
import at.erste.boskovic.stopwordsreaders.FileStopWordReader;
import at.erste.boskovic.ui.ConsoleUserInterface;

public class Main {

    public static final String STOPWORDS_FILE_NAME = "stopword_files/stopwords.txt";

    public static void main(String[] args){
        UserInterface userInterface = new ConsoleUserInterface();
        userInterface.sendToOutput("Write a sentence: ");
        String input = userInterface.readFromInput();
        StopWordsReader stopWordsReader = new FileStopWordReader(STOPWORDS_FILE_NAME);
        WordCounter wordCounter = new RegexWordCounter(stopWordsReader.readStopwords());
        userInterface.sendToOutput("The number of words is: " + wordCounter.countWords(input));
    }
}
