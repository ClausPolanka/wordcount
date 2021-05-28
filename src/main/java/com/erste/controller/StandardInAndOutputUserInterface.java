package com.erste.controller;

import java.util.Scanner;

public class StandardInAndOutputUserInterface implements UserInterface{

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getInput() {
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        return input;
    }
}
