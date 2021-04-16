package com.github.szsalyi.wordcount.io;

import com.github.szsalyi.wordcount.numbercount.UserInterface;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {

    @Override
    public String userInput() {
        System.out.println("Enter: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    @Override
    public void printResult(long wordCount) {
        System.out.println(wordCount);
    }
}
