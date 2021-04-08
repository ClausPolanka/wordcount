import entities.WordCountResult;
import exceptions.FilenameNotProvidedException;
import exceptions.NotValidWordStringException;
import services.WordCountService;
import unit.WordFileReader;
import unit.WordSystemInputReader;

import java.util.List;
import java.util.logging.Logger;

public class WordCountApp {

    private static Logger LOGGER = Logger.getLogger(WordCountApp.class.getName());

    private static WordFileReader wordFileReader = new WordFileReader();
    private static WordSystemInputReader reader = new WordSystemInputReader();
    private static WordCountService wordCountService = new WordCountService();

    public static  void main(String[] args) {
        WordCountApp.run("sometext.txt");
    }

    public static void run(String filename){
        System.out.print("wordcount \n");
        try {
            countFromFile(filename);
        } catch (NotValidWordStringException e) {
            LOGGER.warning("Error occurred trying to count words: "+e.getMessage());
        }
    }

    private static void countFromFile(String filename) throws NotValidWordStringException {
        List<String> inputText;
        try {
            inputText = wordFileReader.loadWords(filename);

        } catch (FilenameNotProvidedException e) {
            inputText = reader.readSystemInput();
        }

        WordCountResult result = wordCountService.count(inputText);

        System.out.print("Number of words: "+ result.getAmountCountableWords() +
                ", unique: " + result.getAmountUniqueWords()+
                "; average word length: " + result.getAverageWordLength() + " characters");
    }
}
