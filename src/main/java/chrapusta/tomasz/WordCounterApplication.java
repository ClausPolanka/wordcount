package chrapusta.tomasz;

public class WordCounterApplication {


 public static void main(String[] args) {

     validateParams(args);
     String inputString = args[0];
     String separator = "@!@";
     WordCounter wordCounter = new WordCounter(separator);
     long countWords = wordCounter.countWords(inputString);
     System.out.println(countWords);

 }

    private static void validateParams(String[] args) {
        if (args.length != 1){
            throw new IllegalArgumentException("Please provide one argument!");
        }
    }
}
