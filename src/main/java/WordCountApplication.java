import com.wordcount.InputUserImpl;
import com.wordcount.ProcessDataImpl;
import com.wordcount.WordCounter;

public class WordCountApplication {

    public static void main(String[] args) {
        WordCounter wc = new WordCounter(new InputUserImpl(), new ProcessDataImpl());
        wc.countWords();
    }
}
