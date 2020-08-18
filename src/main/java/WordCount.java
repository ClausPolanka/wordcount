
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Set;

public class WordCount {

    Set<String> stopWordsMap;

    public WordCount(Set stopWords){
        setStopWordsSet(stopWords);
    }

    public Set<String> getStopWordsSet() {
        return stopWordsMap;
    }

    public void setStopWordsSet(Set<String> stopWordsMap) {
        this.stopWordsMap = stopWordsMap;
    }

    public int countWords(String text){
        int wordCounter = 0;
        String[] words = text.split(" ");
        for(int i = 0; i<=words.length-1; i++){
            if(words[i].matches("^[a-zA-Z]+$") && !isStopWord(words[i])) {
                System.out.println(words[i]);
                wordCounter += 1;
            }

        }
        return wordCounter;
    }


    private boolean isStopWord(String word) {
        return this.getStopWordsSet().contains(word.toLowerCase());
    }

    public static void main(String[] args){

        String inputText;
        int counter;

        try {
            WordCount wordCount = new WordCount(InputHelper.setStopWords());

            if(args.length>0) {
                String fileName = args[0];
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileName));
                inputText = InputHelper.readFile(inputStreamReader);
            }
            else{
                inputText = InputHelper.getConsoleText();
            }

            counter = wordCount.countWords(inputText);

            System.out.println("this is your word count: " + counter);

        } catch (FailedInputException | FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
