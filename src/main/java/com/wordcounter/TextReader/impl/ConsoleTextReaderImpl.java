package com.wordcounter.TextReader.impl;

import com.wordcounter.TextReader.TextReader;

import java.util.Scanner;

public class ConsoleTextReaderImpl implements TextReader {
    @Override
    public String readText() {
        System.out.print("Enter text: ");
        String text = new Scanner(System.in).nextLine();
        return text;
    }
}