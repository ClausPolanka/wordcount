package WordCountApplication.Helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOWorker implements WordCountApplication.Controller.Interfaces.IOWorker {

    private final Scanner scanner;

    public IOWorker(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<String> readFromConsole() {
        List<String> consoleInput = new ArrayList<>();
        String line;
        try{
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
                if(line.isEmpty()){
                    break;
                }
                consoleInput.add(line);
            }
            return consoleInput;
        } catch (Exception exc){
            throw exc;
        } finally {
            scanner.close();
        }
    }
}
