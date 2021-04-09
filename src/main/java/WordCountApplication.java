import controller.WordCountController;
import io.ConsoleIO;
import service.WordCountService;

public class WordCountApplication {

    public static void main(String args[]){

        final ConsoleIO io = new ConsoleIO();
        final WordCountService wordCountService = new WordCountService();
        final WordCountController wordCountController = new WordCountController(io, wordCountService);

        io.displayOutput("Enter text");
        wordCountController.countWords();

    }
}
