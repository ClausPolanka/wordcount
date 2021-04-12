package com.ableneo.erste.wordcount.cli;

public class CliParser {

    private static final String INDEX_ARG = "-index";
    private static final String DICTIONARY_ARG = "-dictionary";

    public CliParameters parse(String[] args) {

        if (args.length == 0) {
            return new CliParameters(false, null, null);
        }

        boolean printIndex = false;
        String inputFileName = null;
        String dictionaryFileName = null;

        for (int i = 0; i < args.length; i++) {
            if (INDEX_ARG.equals(args[i])) {
                printIndex = true;
            } else if (args[i].startsWith(DICTIONARY_ARG)) {
                dictionaryFileName = args[i].split("=")[1];
            } else {
                inputFileName = args[i];
            }
        }

        return new CliParameters(printIndex, inputFileName, dictionaryFileName);
    }
}
