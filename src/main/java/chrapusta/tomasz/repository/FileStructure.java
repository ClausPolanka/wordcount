package chrapusta.tomasz.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class FileStructure implements StopWordsRepository{
    @Override
    public Set<String> getStopWords() throws IOException {
        return new HashSet<>(Files.readAllLines(Paths.get("stopwords.txt")));
    }
}
