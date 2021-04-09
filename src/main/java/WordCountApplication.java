import controller.WordCountController;
import io.ConsoleIO;
import service.WordCountService;
import util.FileBasedStopWords;

public class WordCountApplication {

    public static void main(String args[]){

        final ConsoleIO io = new ConsoleIO();
        final FileBasedStopWords fileBasedStopWords = new FileBasedStopWords();
        final WordCountService wordCountService = new WordCountService(fileBasedStopWords);
        final WordCountController wordCountController = new WordCountController(io, wordCountService);

        System.out.println("Enter text");
        wordCountController.countWords();

    }
}
