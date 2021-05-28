package com.erste.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUserInterface implements UserInterface{

    String fileName;

    public FileUserInterface(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getInput() {
        String wordsAsString = "";
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                wordsAsString = wordsAsString + " " + data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return wordsAsString;
    }
}
