package com.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputTextArchiveImpl implements WordFileResources {

    @Override
    public Set<String> getAllWords(String path) {
        Set<String> wordSet = null;
        try {
            BufferedReader bufferedReader = this.getStopWordFileByPath(path);
            Stream<String> words = bufferedReader.lines()
                    .flatMap(line -> Stream.of(line.split("\\W+")));
            wordSet = words.collect(Collectors.toSet());
        } catch (IOException e) {
            System.out.println("Failed to load: "  +path + "." +" File name seems to wrong or file can be empty");
         }
        return wordSet;
    }

    public BufferedReader getStopWordFileByPath(String path) throws IOException {
        return Files.newBufferedReader(Paths.get(path));
    }

}
