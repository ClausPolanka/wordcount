package wordcount;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DictionaryImpl implements IDictionary {

    private Set<String> ENTRIES = new HashSet<>();

    public DictionaryImpl(final String filename) {
        try (InputStream is = new FileInputStream(filename)) {
            Scanner scanner = new Scanner(is);
            while (scanner.hasNextLine()) {
                ENTRIES.add(scanner.nextLine().trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean contains(final String word) {
        return ENTRIES.contains(word);
    }
}
