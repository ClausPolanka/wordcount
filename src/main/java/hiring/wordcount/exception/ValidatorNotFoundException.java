package hiring.wordcount.exception;

public class ValidatorNotFoundException extends Exception {
    public ValidatorNotFoundException(String wordValidator) {
        super(wordValidator);
    }
}
