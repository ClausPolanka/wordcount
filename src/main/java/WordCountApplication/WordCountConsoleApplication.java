package WordCountApplication;

import WordCountApplication.Controller.WordCounter;
import WordCountApplication.Helpers.IOWorker;
import WordCountApplication.View.WordCounterConsoleView;

import java.util.Scanner;

public class WordCountConsoleApplication {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final WordCounterConsoleView consoleView = new WordCounterConsoleView();
        final IOWorker ioWorker = new IOWorker(scanner);
        final WordCounter wordCounter = new WordCounter(consoleView, ioWorker);
        wordCounter.countWords();
    }
}
