package root.service.impl;

import root.service.StopWordsProviderInterface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileStopWordsProvider implements StopWordsProviderInterface {

    private final Set<String> stopWords = new HashSet<>();


    public FileStopWordsProvider() {
        try {
            Scanner scanner = new Scanner(new FileInputStream("src/main/resources/stopwords.txt"));
            while (scanner.hasNextLine()) {
                stopWords.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<String> getStopWords() {
       return this.stopWords;
    }
}
