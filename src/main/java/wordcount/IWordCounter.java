package wordcount;

public interface IWordCounter {
    int count(String inputText);

    int countUnique(String inputText);

    double averageLength(String inputText);
}
