package io;

import model.WordDetailsDTO;

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
    public void displayOutput(WordDetailsDTO wordDetailsDTO) {

        final String output = String.format("Number of words: %d, unique:%d;  average word length: %d characters",
                wordDetailsDTO.getCount(), wordDetailsDTO.getUniqueCount(), wordDetailsDTO.getAverageLength());
        System.out.println(output);

    }
}
