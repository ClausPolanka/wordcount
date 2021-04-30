package stopwords;

import filereader.FileReader;

import java.util.ArrayList;
import java.util.List;

public final class Stopwords {
    private static final List<String> stopwords;

    static {
        stopwords = FileReader.readLines("stopwords.txt");

    }

    private Stopwords() {
        // private access
    }

    public static List<String> getStopwords() {
        return new ArrayList<>(stopwords);
    }
}
