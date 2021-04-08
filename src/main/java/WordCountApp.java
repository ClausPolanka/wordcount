
public class WordCountApp {

    public static  void main(String[] args) {
        WordCountApp.run();
    }

    private static void run(){
        WordInputReader reader = new WordInputReader();
        WordCountService wordCountService = new WordCountService();

        System.out.print("wordcount \n");

        String inputText = reader.readSystemInput();
        int wordsCount = wordCountService.count(inputText);

        System.out.print("Number of words: " + wordsCount);
    }
}
