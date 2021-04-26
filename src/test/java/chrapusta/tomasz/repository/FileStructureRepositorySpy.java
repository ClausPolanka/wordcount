package chrapusta.tomasz.repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FileStructureRepositorySpy implements FileStructureRepository {

    @Override
    public Set<String> readAllLines(String fileName) throws IOException, URISyntaxException {
        return new HashSet<>(Arrays.asList("the", "a", "on", "off"));
    }

    @Override
    public String readFile(String fileName) throws IOException, URISyntaxException {
        //TODO implement this
        return null;
    }
}
