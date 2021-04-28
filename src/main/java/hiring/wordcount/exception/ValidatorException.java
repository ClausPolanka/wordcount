package hiring.wordcount.exception;

public class ValidatorException extends Exception {
    public ValidatorException(String msg){
        super(msg);
    }

    public ValidatorException(Exception exception){
        super(exception);
    }

}
