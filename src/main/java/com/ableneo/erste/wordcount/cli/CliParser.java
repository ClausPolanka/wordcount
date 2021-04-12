package com.ableneo.erste.wordcount.cli;

public class CliParser {

    private static final String INDEX_ARG = "-index";

    public CliParameters parse(String[] args) {

        if (args.length == 0) {
            return new CliParameters(false, null);
        }

        boolean printIndex = false;
        String fileName = null;

        if (INDEX_ARG.equals(args[0])) {
            printIndex = true;
        } else {
            fileName = args[0];
        }

        if (args.length > 1) {
            fileName = args[1];
        }

        return new CliParameters(printIndex, fileName);
    }
}
