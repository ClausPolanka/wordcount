package at.erste.boskovic.ui;

import at.erste.boskovic.InputTextReader;

import java.io.InputStream;
import java.util.Scanner;

import static java.util.Objects.nonNull;

public class FileInputTextReader implements InputTextReader {

    private final String inputFileName;

    public FileInputTextReader(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    @Override
    public String readInput() {
        StringBuilder inputStringBuilder = new StringBuilder();

        InputStream inputSentenceStream = getClass().getClassLoader().getResourceAsStream(inputFileName);

        if (nonNull(inputSentenceStream)) {
            Scanner myReader = new Scanner(inputSentenceStream);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                inputStringBuilder.append(line);
                if (myReader.hasNextLine()){
                    inputStringBuilder.append("\n");
                }
            }
        }

        return inputStringBuilder.toString();
    }
}
