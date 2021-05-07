package wordcount;
import java.util.Set;

public interface StopwordsProvider {
    Set<String> getStopWords();
}
