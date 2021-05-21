package WordCountApplication.Controller.Interfaces;

import java.util.List;

public interface IOWorker {

    List<String> readFromConsole();
    List<String> fileReader(String fileName);
}
