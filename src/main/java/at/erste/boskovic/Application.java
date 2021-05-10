package at.erste.boskovic;

import at.erste.boskovic.implementation.RegexWordCounter;
import at.erste.boskovic.stopwordsreaders.FileStopWordReader;
import at.erste.boskovic.ui.ConsoleInputTextReader;
import at.erste.boskovic.ui.ConsoleUserInterface;
import at.erste.boskovic.ui.FileInputTextReader;

public class Application {

    public long countWordsFromInput(String[] args, String stopwordsFileName){

        String input;
        InputTextReader inputTextReader;

        if(args.length == 0) {
            new ConsoleUserInterface().sendToOutput("Enter text:");
            inputTextReader = new ConsoleInputTextReader();
        } else {
            inputTextReader = new FileInputTextReader(args[0]);
        }

        input = inputTextReader.readInput();
        StopWordsReader stopWordsReader = new FileStopWordReader(stopwordsFileName);
        WordCounter wordCounter = new RegexWordCounter(stopWordsReader.readStopwords());
        return wordCounter.countWords(input);
    }
}
