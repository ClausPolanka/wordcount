package com.oscerba.george.input;

import java.util.Scanner;

public class WordProvider {
    public String[] getWords() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        return input.split("\\s");
    }
}
