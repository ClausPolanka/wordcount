package root.infrastructure;

import root.wordcounter.StopWordsProviderInterface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileStopWordsProvider implements StopWordsProviderInterface {

    private final Set<String> stopWords = new HashSet<>();


    public FileStopWordsProvider() {
        try {
            URL stopWordsFile = getClass().getClassLoader().getResource("stopwords.txt");
            if(stopWordsFile != null) {
                Scanner scanner = new Scanner(new FileInputStream(stopWordsFile.getFile()));
                while (scanner.hasNextLine()) {
                    stopWords.add(scanner.nextLine());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Warning: Stopwords file not found");
        }
    }

    @Override
    public Set<String> getStopWords() {
       return this.stopWords;
    }
}
