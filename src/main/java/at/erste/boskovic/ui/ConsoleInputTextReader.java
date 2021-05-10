package at.erste.boskovic.ui;

import at.erste.boskovic.InputTextReader;

import java.util.Scanner;

public class ConsoleInputTextReader implements InputTextReader {

    @Override
    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
