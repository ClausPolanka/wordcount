package com.wordcount;

import java.io.InputStreamReader;
import java.util.Scanner;

public class InputUserImpl implements InputUser {

    /****
     * This function ask for scanner input and returns it as a String
     * @return a string
     */
    @Override
    public String getUserInput() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("word count: ");
        return scanner.nextLine();
    }
}
