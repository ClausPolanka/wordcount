package chrapusta.tomasz.repository;

public class CommandLine implements WordRepository {

    private String[] input;

    @Override
    public String[] getInput() {
        return input;
    }

    @Override
    public void writeCount(long countWords) {
        System.out.println("Count words is equal: " + countWords);
    }

    @Override
    public void setValidatedInput(String[] input) {
        validateParams(input);
        this.input = input;
    }

    private void validateParams(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Please provide one argument!");
        }
    }
}
