package com.ableneo.erste.wordcount.cli;

public class CliParameters {

    private boolean printIndex;
    private String fileName;

    public CliParameters(boolean printIndex, String fileName) {
        this.printIndex = printIndex;
        this.fileName = fileName;
    }

    public boolean isPrintIndex() {
        return printIndex;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean isFileBasedInput() {
        return fileName != null;
    }
}
