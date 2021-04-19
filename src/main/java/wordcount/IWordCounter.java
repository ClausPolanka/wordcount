package wordcount;

import java.util.List;

public interface IWordCounter {
    int count(String inputText);

    int countUnique(String inputText);

    double averageLength(String inputText);

    List<String> getIndex(String inputText);
}
