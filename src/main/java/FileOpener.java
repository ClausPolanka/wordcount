import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOpener {

    public List<String> openTextFileFromResources(String fileName) throws FileNotFoundException, FormatException {

        List<String> lines = new ArrayList<>();

        if (fileName == null) {
            throw new FileNotFoundException();
        }

        if (!fileName.endsWith(".txt")){
            throw new FormatException("File must be in .txt format");
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
