package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIO implements InputOutputInterface {

    @Override
    public String getInput() throws IOException {

        final BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        final String name = reader.readLine();

        return name;

    }

    @Override
    public String displayOutput(String outputString) {

        final String output = "Number of words: " + outputString;
        System.out.println(output);
        return output;

    }
}
