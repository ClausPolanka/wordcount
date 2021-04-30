package filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class FileReader {

    private FileReader() {
        // private access
    }

    public static List<String> readLines(String path) {
        String localPath = "files/" + path;
        try {
            return Files.readAllLines(Paths.get(localPath));
        } catch (IOException e) {
            System.out.println("Path is not valid. No resource was loaded");
            return new ArrayList<>();
        }
    }
}
