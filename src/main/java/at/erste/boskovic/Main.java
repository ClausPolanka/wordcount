package at.erste.boskovic;

import at.erste.boskovic.ui.ConsoleUserInterface;

public class Main {

    public static final String STOPWORDS_FILE_NAME = "stopword_files/stopwords.txt";

    public static void main(String[] args){
        Application application = new Application();
        long numberOfWords = application.countWordsFromInput(args, STOPWORDS_FILE_NAME);
        UserInterface userInterface = new ConsoleUserInterface();
        userInterface.sendToOutput("Number of words: " + numberOfWords);
    }
}
