package sk.sloboda.wordcount.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class ArgumentHelper {

    private File inputFile;

    public boolean isFileNameEntered(String argument) {
        if (argument == null || argument.isEmpty())
            return false;

        inputFile = new File(argument);
        if (!inputFile.exists()) {
            inputFile = new File(String.format("input/%s", argument));
            return inputFile.exists();
        }
        return true;
    }

    public String loadTextFromFile() {
        try {
            return Files.readAllLines(inputFile.toPath()).stream().map(Object::toString).collect(Collectors.joining(" "));
        } catch (IOException e) {
            System.err.printf("Unable to load input from text file %s, cause: %s. %n", inputFile.getPath(), e.getCause());
        }
        return null;
    }
}
