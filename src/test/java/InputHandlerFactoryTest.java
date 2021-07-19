import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputHandlerFactoryTest {

    @Test
    public void givenArguments_whenCreatingAInputHandler_thenReturnTheFileInputHandler() {
        // given
        String[] args = new String[]{"file.txt"};

        //when
        InputHandler fileInputHandler = InputHandlerFactory.create(args);

        //then
        Assertions.assertEquals(fileInputHandler.getClass(), FileInputHandler.class);
    }

    @Test
    public void givenNoArgs_whenCreatingAInputHandler_thenReturnTheConsoleInputHandler() {
        // given
        String[] args = new String[0];

        //when
        InputHandler fileInputHandler = InputHandlerFactory.create(args);

        //then
        Assertions.assertEquals(fileInputHandler.getClass(), ConsoleInputHandler.class);
    }

}