package com.github.szsalyi.wordcount.io;

import com.github.szsalyi.wordcount.numbercount.UserIO;

import java.util.Scanner;

public class ConsoleUserInput implements UserIO {

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
