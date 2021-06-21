package wordcount.error;

import wordcount.io.ErrorCode;

public class WrappedException extends RuntimeException {


    public WrappedException(String message) {
        super(message);
    }

    public WrappedException(ErrorCode message, Throwable cause) {
        super(message.name(), cause);
    }
}
