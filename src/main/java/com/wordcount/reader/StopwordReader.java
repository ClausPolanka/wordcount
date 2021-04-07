package com.wordcount.reader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StopwordReader {

    public List<String> readStopwords() {
        //TODO cleanup

        String fileName = "stopwords.txt";

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }

        String data = null;
        List<String> stopwords = new ArrayList<>();

        Scanner myReader = new Scanner(inputStream);
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            stopwords.add(data);
        }
        myReader.close();

        return stopwords;
    }

}
