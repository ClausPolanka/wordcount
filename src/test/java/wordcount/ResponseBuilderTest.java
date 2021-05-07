package wordcount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseBuilderTest {

    @DisplayName("Given output is 5 then return a nice message")
    @Test
    public void testOutput() {
        ResponseBuilder responseBuilder = new ResponseBuilder();

        String outputMessage = responseBuilder.createOutputMessage(5);

        assertEquals(outputMessage, "Number of words: 5");
    }

}