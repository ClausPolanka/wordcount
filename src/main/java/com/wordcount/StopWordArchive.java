package com.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordArchive {

    public BufferedReader getStopWordFileByPath(String path) throws IOException {
        return Files.newBufferedReader(Paths.get(path));
    }

    public Set<String> getExcludeWords(String path) {
        try {
            BufferedReader bufferedReader = this.getStopWordFileByPath(path);
            return Collections.unmodifiableSet(bufferedReader.lines().collect(Collectors.toSet()));
        } catch (IOException e) {
            System.out.println("Failed to load the stop word file. Stop word file is therefore empty");
        }
        return new HashSet<>();
    }




}
