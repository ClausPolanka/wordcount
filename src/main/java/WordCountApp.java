import java.util.List;

public class WordCountApp {

    private static WordFileReader wordFileReader = new WordFileReader();
    private static WordSystemInputReader reader = new WordSystemInputReader();
    private static WordCountService wordCountService = new WordCountService();

    public static  void main(String[] args) {
        WordCountApp.run("mytext.txt");
    }

    public static void run(String filename){
        System.out.print("wordcount \n");
        countFromFile(filename);
    }

    private static void countFromFile(String filename){
        List<String> inputText;
        try {
            inputText = wordFileReader.loadWords(filename);

        } catch (FilenameNotProvidedException e) {
            inputText = reader.readSystemInput();
        }

        int wordsCount = wordCountService.count(inputText);

        System.out.print("Number of words: " + wordsCount);
    }
}
