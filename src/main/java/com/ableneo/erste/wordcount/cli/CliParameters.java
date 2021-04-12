package com.ableneo.erste.wordcount.cli;

public class CliParameters {

    private boolean printIndex;
    private String inputFileName;
    private String dictionaryFileName;

    public CliParameters(boolean printIndex, String inputFileName, String dictionaryFileName) {
        this.printIndex = printIndex;
        this.inputFileName = inputFileName;
        this.dictionaryFileName = dictionaryFileName;
    }

    public boolean isPrintIndex() {
        return printIndex;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public String getDictionaryFileName() {
        return dictionaryFileName;
    }

    public boolean isFileBasedInput() {
        return inputFileName != null;
    }

    public boolean isDictionaryBasedOutput() {
        return dictionaryFileName != null;
    }
}
