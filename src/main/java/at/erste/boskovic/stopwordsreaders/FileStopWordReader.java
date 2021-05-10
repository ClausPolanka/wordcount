package at.erste.boskovic.stopwordsreaders;

import at.erste.boskovic.StopWordsReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.nonNull;

public class FileStopWordReader implements StopWordsReader {

    private static final String STOPWORDS_FILE_NAME = "stopword_test_files/test_stopwords.txt";

    @Override
    public List<String> readStopwords() {
        InputStream stopWordsInputStream = getClass().getClassLoader().getResourceAsStream(STOPWORDS_FILE_NAME);

        List<String> stopWords = new ArrayList<>();

        if (nonNull(stopWordsInputStream)) {
            Scanner myReader = new Scanner(stopWordsInputStream);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                stopWords.add(line);
            }
        }

        return stopWords;
    }
}
