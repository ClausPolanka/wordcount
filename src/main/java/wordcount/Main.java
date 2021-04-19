package wordcount;

import wordcount.impl.*;
import wordcount.util.FileUtils;

import java.util.Scanner;

public class Main {
    private final IOutputHandler outputHandler;

    public Main(IOutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public static void main(String[] args) {
        String inputFilename = null;
        boolean printIndex = false;
        String dictionaryFilename = null;
        final IWordCounter wordCounter = new WordCounterAllowedDashImpl("stopwords.txt");

        for (int i = 0; i < args.length; i++) {
            final String[] params = args[i].split("=");
            switch (params[0]) {
                case "-index":
                    printIndex = true;
                    break;
                case "-dictionary":
                    dictionaryFilename = params[1];
                    break;
                default:
                    inputFilename = args[i];
            }
        }
        final IOutputHandler outputHandler = createOutputHandler(dictionaryFilename, printIndex, wordCounter);

        final Main main = new Main(outputHandler);
        final String inputText = inputFilename != null ? main.readInput(inputFilename) : main.readInput();

        main.printOutput(inputText);
    }

    private static IOutputHandler createOutputHandler(final String dictionaryFilename, final boolean printIndex, final IWordCounter wordCounter) {
        if (!printIndex) {
            return new OutputHandlerImpl(wordCounter);
        }
        if (dictionaryFilename != null) {
            return new DictCheckedIndexOutputHandlerImpl(wordCounter, new DictionaryImpl(dictionaryFilename));
        } else {
            return new IndexOutputHandlerImpl(wordCounter);
        }
    }

    private void printOutput(final String inputText) {
        outputHandler.printOutput(inputText);
    }

    public String readInput() {
        System.out.print("Enter text: ");
        return new Scanner(System.in).nextLine();
    }

    public String readInput(final String fileName) {
        return FileUtils.readFileAsString(fileName);
    }
}
