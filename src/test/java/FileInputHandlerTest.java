import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileInputHandlerTest {

    @Test
    public void givenWrongFileName_shouldThrowException() {
        // fileName
        String fileName = "doesnotexist.txt";

        // when
        FileInputHandler fileInputHandler = new FileInputHandler(fileName);
        Assertions.assertThrows(RuntimeException.class, fileInputHandler::getInputText);
    }

    @Test
    public void givenFileName_shouldReturnItsContentAsString() {
        // fileName
        String fileName = "/tmp/text.txt";

        // when
        FileInputHandler fileInputHandler = new FileInputHandler(fileName);
        String text = fileInputHandler.getInputText();

        // then
        Assertions.assertEquals("Eni is working with Erste team", text);
    }

}