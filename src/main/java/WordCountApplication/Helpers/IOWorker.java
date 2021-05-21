package WordCountApplication.Helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOWorker implements WordCountApplication.Controller.Interfaces.IOWorker {

    private final Scanner scanner;
    private Scanner fileScanner;
    private static String contentRout = "src/resources/";

    public IOWorker(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String singleLineReader() {
        return scanner.nextLine();
    }

    @Override
    public List<String> readFromConsole() {
        List<String> consoleInput = new ArrayList<>();
        String line;
        try {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                consoleInput.add(line);
            }
            return consoleInput;
        } catch (Exception exc) {
            throw exc;
        } finally {
            scanner.close();
        }
    }

    @Override
    public List<String> fileReader(String fileName) {
        List<String> linesOfFile = new ArrayList<>();
        try {
            File file = new File(contentRout + "/" + fileName);
            fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                linesOfFile.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException exc) {
            return linesOfFile;
        } finally {
            if (fileScanner != null) fileScanner.close();
        }
        return linesOfFile;
    }
}
