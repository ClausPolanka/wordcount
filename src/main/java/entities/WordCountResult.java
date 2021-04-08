package entities;

public class WordCountResult {

    private int amountCountableWords;
    private int amountUniqueWords;
    private double averageWordLength;

    public WordCountResult(int amountCountableWords,
                           int amountUniqueWords,
                           double averageWordLength) {

        this.amountCountableWords = amountCountableWords;
        this.amountUniqueWords = amountUniqueWords;
        this.averageWordLength = averageWordLength;
    }

    public int getAmountCountableWords() {
        return amountCountableWords;
    }

    public int getAmountUniqueWords() {
        return amountUniqueWords;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }
}
