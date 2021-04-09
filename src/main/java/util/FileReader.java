package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static List<String> getWordsFromFile(String filePath) {

        List<String> wordsFromFile = null;

        try {

            wordsFromFile = new ArrayList<>();
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                wordsFromFile.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();

        }

        return wordsFromFile;

    }
}
