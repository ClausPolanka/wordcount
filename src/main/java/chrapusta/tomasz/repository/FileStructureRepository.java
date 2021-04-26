package chrapusta.tomasz.repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

public interface FileStructureRepository {
    Set<String> readAllLines(String fileName) throws IOException, URISyntaxException;

    String readFile(String fileName) throws IOException, URISyntaxException;
}
