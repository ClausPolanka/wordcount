import com.wordcount.InputUserImpl;
import com.wordcount.ProcessDataImpl;
import com.wordcount.ProcessTextDataImpl;
import com.wordcount.WordCounter;

public class WordCountApplication {

    public static void main(String[] args) {
        WordCounter wc = new WordCounter(new InputUserImpl(), new ProcessDataImpl(), new ProcessTextDataImpl());
        wc.countWords();
    }
}
