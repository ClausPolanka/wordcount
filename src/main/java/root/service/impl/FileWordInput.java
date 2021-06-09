package root.service.impl;

import root.service.WordInputInterface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileWordInput implements WordInputInterface {

    private final Scanner scanner;

    public FileWordInput(String file) throws InvalidUserInputException {

        try {
            this.scanner = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new InvalidUserInputException("File not found", e);
        }

    }

    @Override
    public String getInput() {
        StringBuilder text = new StringBuilder();
        while (scanner.hasNextLine()) {
            text.append(scanner.nextLine());
            if(scanner.hasNextLine()) {
                text.append("\n");
            }
        }
        return text.toString();
    }
}
