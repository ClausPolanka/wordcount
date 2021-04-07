package com.wordcount.io;

import com.wordcount.dto.CounterDto;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputOutputHelper {

    public String read(String args[]) {
        if (args.length > 0) {
            return readFromFile(args[0]);
        } else {
            return readFromCommandline();
        }
    }

    public String readFromFile(String filename) {
        Path path = Paths.get(filename);
        String text = null;
        try {
            text = Files.readAllLines(path).stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" "));
        } catch (IOException e) {
            System.out.println("File not found: " + filename);
            System.exit(1);
        }
        return text;
    }

    public String readFromCommandline() {
        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        return scanner.nextLine();
    }

    public void write(CounterDto counter) {
        System.out.println("Number of words: " + counter.getNumberOfWords() + ", unique: " + counter.getNumberOfUniqueWords());
    }

}
