package wordcount.error;

import org.junit.jupiter.api.Test;
import wordcount.error.WrappedException;
import wordcount.io.Errors;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WrappedExceptionTest {

   @Test
    void assertWrappedExceptionWithMessageToBeThrown() {

       final WrappedException wrappedException = assertThrows(WrappedException.class,
               () -> {
                   throw new WrappedException("message");
               });
       assertEquals("message", wrappedException.getMessage());

   }

    @Test
    void assertWrappedExceptionWithMessageAndWrappedError() {

        final WrappedException wrappedException = assertThrows(WrappedException.class,
                ()-> { throw new WrappedException(Errors.READ_TEXT_ERROR, new IOException());});

        assertEquals(IOException.class, wrappedException.getCause().getClass());
   }
}
