package wordcount.error;

import wordcount.io.Errors;

public class WrappedException extends RuntimeException {


    public WrappedException(String message) {
        super(message);
    }

    public WrappedException(Errors message, Throwable cause) {
        super(message.name(), cause);
    }
}
