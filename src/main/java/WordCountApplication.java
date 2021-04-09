import controller.WordCountController;
import io.ConsoleIO;
import io.FileBasedUI;
import io.UserInterface;
import service.WordCountService;
import util.FileBasedStopWords;

public class WordCountApplication {

    public static void main(String args[]){

        final UserInterface userInterface;
        final FileBasedStopWords fileBasedStopWords = new FileBasedStopWords();
        final WordCountService wordCountService = new WordCountService(fileBasedStopWords);


        if (args.length == 0) {

            userInterface = new ConsoleIO();
            System.out.println("Enter text");

        } else {

            userInterface = new FileBasedUI(args[0]);

        }

        final WordCountController wordCountController = new WordCountController(userInterface, wordCountService);

        wordCountController.countWords();

    }
}
