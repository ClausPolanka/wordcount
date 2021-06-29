import exceptions.FormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOpener {

    private final static String TXT_FORMAT = ".txt";

    private final static String FORMAT_NOT_TEXT_MESSAGE = "File must be in .txt format";

    public List<String> openTextFileFromResources(String fileName) throws FileNotFoundException, FormatException {

        List<String> lines = new ArrayList<>();

        if (fileName == null) {
            throw new FileNotFoundException();
        }

        if (!fileName.endsWith(TXT_FORMAT)){
            throw new FormatException(FORMAT_NOT_TEXT_MESSAGE);
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

            throw new FileNotFoundException();
        }

        return lines;
    }
}
