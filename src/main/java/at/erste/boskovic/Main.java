package at.erste.boskovic;

import at.erste.boskovic.implementation.RegexWordCounter;
import at.erste.boskovic.ui.ConsoleUserInterface;

public class Main {

    public static void main(String[] args){
        UserInterface userInterface = new ConsoleUserInterface();
        userInterface.sendToOutput("Write a sentence: ");
        String input = userInterface.readFromInput();
        WordCounter wordCounter = new RegexWordCounter();
        userInterface.sendToOutput("The number of words is: " + wordCounter.countWords(input));
    }
}
