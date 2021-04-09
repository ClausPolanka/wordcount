package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIO implements UserInterface {

    @Override
    public String getInput() {

        String input = null;

        try {

            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            input = reader.readLine();

        } catch (IOException exception) {

            System.out.println(exception.getMessage());
        }

        return input;

    }

    @Override
    public void displayOutput(int count) {

        final String output = "Number of words: " + count;
        System.out.println(output);

    }
}
