package chrapusta.tomasz.repository;

public interface WordRepository {

    String[] getInput();

    void writeCount(long countWords);

    void setValidatedInput(String[] input);
}
