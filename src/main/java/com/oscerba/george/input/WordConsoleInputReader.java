package com.oscerba.george.input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordConsoleInputReader extends WordInputReader {

    @Override
    public List<String> getWords() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        return Arrays.asList(input.split("\\s"));
    }
}
