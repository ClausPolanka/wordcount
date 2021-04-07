package com.wordcount.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class StopwordReader {

    public List<String> readStopwords() {
        String fileName = "stopwords.txt";

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);


        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }

        String data = null;
        List<String>

        Scanner myReader = new Scanner(inputStream);
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
        }
        myReader.close();

        return data;
    }

}
