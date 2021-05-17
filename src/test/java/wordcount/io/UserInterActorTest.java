package wordcount.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserInterActorTest {
    public static final String MESSAGE_TO_THE_USER = "Message to the user";
    public static final String MESSAGE_FROM_THE_USER = "Message from the user";

    private Scanner scanner;
    private BufferedWriter bufferedWriter;
    private StringWriter stringWriter = new StringWriter();

    private UserInterActor sut;

    @BeforeEach
    void setUp() throws IOException {
        scanner = new Scanner(MESSAGE_FROM_THE_USER);
        bufferedWriter = new BufferedWriter(stringWriter);

        sut = new UserInterActor(scanner, bufferedWriter);
    }

    @AfterEach
    void tearDown() throws IOException {
        bufferedWriter.close();
    }

    @Test
    void should_Write_Message_To_User() throws IOException {
        sut.read(MESSAGE_TO_THE_USER);

        assertEquals(MESSAGE_TO_THE_USER, getWriteMessage());
    }

    @Test
    void should_Read_Answer_From_User() throws IOException {
        String actual = sut.read(MESSAGE_TO_THE_USER);

        assertEquals(MESSAGE_FROM_THE_USER, actual);
    }

    private String getWriteMessage() {
        return stringWriter.getBuffer().toString();
    }
}