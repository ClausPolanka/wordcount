package chrapusta.tomasz.repository;

public class WordRepositorySpy implements WordRepository {

    private String[] input;
    private long countWords;

    @Override
    public String[] getInput() {
        return this.input;
    }

    @Override
    public void writeCount(long countWords) {
        this.countWords = countWords;
    }

    @Override
    public void setValidatedInput(String[] input) {
        this.input = input;
    }

    public long getCountWords() {
        return countWords;
    }
}
