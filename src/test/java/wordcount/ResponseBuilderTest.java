package wordcount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseBuilderTest {

    @DisplayName("Given output is 5 then return a nice message")
    @Test
    public void testOutput() {
        ResponseBuilder responseBuilder = new ResponseBuilder();

        String outputMessage = responseBuilder.createOutputMessage(
                new WordCounterOutput()
                    .setWordCount(5)
                    .setUniqueCount(4)
        );

        String expected = "Number of words: 5, unique: 4";
        assertEquals(expected,outputMessage);
    }

}