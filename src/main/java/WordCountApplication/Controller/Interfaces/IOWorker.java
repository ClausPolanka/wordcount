package WordCountApplication.Controller.Interfaces;

import java.util.List;

public interface IOWorker {

    String singleLineReader();
    List<String> readFromConsole();
    List<String> fileReader(String fileName);
}
