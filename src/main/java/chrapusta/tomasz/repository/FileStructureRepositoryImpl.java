package chrapusta.tomasz.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FileStructureRepositoryImpl implements FileStructureRepository {

    @Override
    public Set<String> readAllLines(final String fileName) throws IOException, URISyntaxException {
        return new HashSet<>(
                Files.readAllLines(Paths.get(getResource(fileName).toURI())));
    }

    @Override
    public String readFile(String fileName) throws IOException, URISyntaxException {
        return readAllLines(fileName)
                .stream()
                .collect(Collectors.joining(" "));
    }

    private URL getResource(String fileName) throws FileNotFoundException {
        URL url = getClass().getResource(fileName);
        if (url == null) {
            throw new FileNotFoundException("Provided url is null. Please check the url.");
        }
        return url;
    }


}
