import exceptions.FormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOpener {

    private static final String TXT_FORMAT = ".txt";

    private static final String FILE_NOT_IN_TXT_FORMAT_MESSAGE = "File must be in .txt format";

    private static final String FILE_NOT_FOUND_MESSAGE = "File not found";

    public List<String> openTextFileFromResources(String fileName) throws FileNotFoundException, FormatException {

        List<String> lines = new ArrayList<>();

        if (fileName == null) {
            throw new FileNotFoundException(FILE_NOT_FOUND_MESSAGE);
        }

        if (!fileName.endsWith(TXT_FORMAT)){
            throw new FormatException(FILE_NOT_IN_TXT_FORMAT_MESSAGE);
        }

        URL url = getClass().getResource(fileName);
        File file;

        if (url != null) {

            file = new File(url.getPath());

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } else{
            throw new FileNotFoundException(FILE_NOT_FOUND_MESSAGE);
        }

        return lines;
    }
}
