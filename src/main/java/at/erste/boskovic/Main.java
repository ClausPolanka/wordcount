package at.erste.boskovic;

import at.erste.boskovic.ui.ConsoleUserInterface;

public class Main {

    public static void main(String[] args){
        Application application = new Application();
        long numberOfWords = application.countWordsFromInput(args);
        UserInterface userInterface = new ConsoleUserInterface();
        userInterface.sendToOutput("The number of words is: " + numberOfWords);
    }
}
