package root.service.impl;

import java.io.IOException;

public class InvalidUserInputException extends IOException {

    public InvalidUserInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
