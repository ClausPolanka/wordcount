package chrapusta.tomasz.repository;

import java.io.IOException;
import java.util.Set;

public interface StopWordsRepository {
    Set<String> getStopWords() throws IOException;
}
