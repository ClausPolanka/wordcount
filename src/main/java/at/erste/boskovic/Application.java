package at.erste.boskovic;

import at.erste.boskovic.implementation.RegexWordCounter;
import at.erste.boskovic.stopwordsreaders.FileStopWordReader;
import at.erste.boskovic.ui.ConsoleInputTextReader;
import at.erste.boskovic.ui.ConsoleUserInterface;
import at.erste.boskovic.ui.FileInputTextReader;

public class Application {

    public static final String STOPWORDS_FILE_NAME = "stopword_files/stopwords.txt";

    public long countWordsFromInput(String[] args){

        String input;
        InputTextReader inputTextReader;

        if(args.length == 0) {
            inputTextReader = new ConsoleInputTextReader();
        } else {
            inputTextReader = new FileInputTextReader(args[0]);
        }

        input = inputTextReader.readInput();
        StopWordsReader stopWordsReader = new FileStopWordReader(Application.STOPWORDS_FILE_NAME);
        WordCounter wordCounter = new RegexWordCounter(stopWordsReader.readStopwords());
        return wordCounter.countWords(input);
    }
}
