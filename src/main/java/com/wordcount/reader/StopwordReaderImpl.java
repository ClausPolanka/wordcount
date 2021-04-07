package com.wordcount.reader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StopwordReaderImpl implements StopwordReader {

    @Override
    public List<String> readStopwords() {
        String fileName = "stopwords.txt";

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            return new ArrayList<>();
        }

        List<String> stopwords = new ArrayList<>();
        Scanner myReader = new Scanner(inputStream);
        while (myReader.hasNextLine()) {
            String word = myReader.nextLine();
            stopwords.add(word);
        }
        myReader.close();
        return stopwords;
    }

}
