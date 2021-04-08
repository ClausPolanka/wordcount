package entities;

public class WordCountResult {

    private int amountCountableWords;
    private int amountUniqueWords;

    public WordCountResult(int amountCountableWords, int amountUniqueWords) {
        this.amountCountableWords = amountCountableWords;
        this.amountUniqueWords = amountUniqueWords;
    }

    public int getAmountCountableWords() {
        return amountCountableWords;
    }

    public int getAmountUniqueWords() {
        return amountUniqueWords;
    }
}
