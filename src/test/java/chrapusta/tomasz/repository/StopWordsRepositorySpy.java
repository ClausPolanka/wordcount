package chrapusta.tomasz.repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StopWordsRepositorySpy implements StopWordsRepository {

    @Override
    public Set<String> getStopWords() {
        return new HashSet<>(Arrays.asList("the", "a", "on", "off"));
    }
}
