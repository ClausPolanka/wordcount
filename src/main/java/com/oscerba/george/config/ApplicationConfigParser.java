package com.oscerba.george.config;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ApplicationConfigParser {

    public static final String INDEX_COMMAND_LINE_ARG = "-index";

    public ApplicationConfig parse(String[] args) {
        List<String> argList = Arrays.asList(args);
        int index = argList.indexOf(INDEX_COMMAND_LINE_ARG);
        boolean indexEnabled;
        if (index != -1) {
            indexEnabled = true;
            argList.remove(index);
        } else {
            indexEnabled = false;
        }

        Path inputFilePath;
        if (!argList.isEmpty()) {
            inputFilePath = Paths.get(argList.get(0));
        } else {
            inputFilePath = null;
        }

        return new ApplicationConfig(indexEnabled, inputFilePath);
    }
}
