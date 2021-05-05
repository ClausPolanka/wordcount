package sk.sloboda.wordcount.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static sk.sloboda.wordcount.common.Constants.INDEX_ARGUMENT;

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

    public boolean showIndex(String[] args) {
        if (args == null || args.length == 0) return false;

        Optional<String> indexArg = Arrays.stream(args).filter(arg -> arg.equalsIgnoreCase(INDEX_ARGUMENT)).findAny();
        return indexArg.isPresent();
    }
}
