package at.erste.boskovic.ui;

import at.erste.boskovic.UserInterface;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {

    private static final Scanner CONSOLE_SCANER = new Scanner(System.in);

    @Override
    public String readFromInput() {
        return CONSOLE_SCANER.nextLine();
    }

    @Override
    public void sendToOutput(String output) {
        System.out.println(output);
    }
}
