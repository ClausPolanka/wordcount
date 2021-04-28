package hiring.wordcount.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class FileInputServiceTest extends BaseServiceTest {
    private FileInputService service;

    @BeforeEach
    public void setUp() {
        service = new FileInputService();
    }

    @Test
    public void testName() {
        super.getServiceName(service);
    }

    @Test
    public void testReadForInvalidParameterException(){
        assertThrows(InvalidParameterException.class, () -> service.read(null));
        assertThrows(InvalidParameterException.class, () -> service.read(""));
    }

    @Test
    public void testReadForFileNotFoundException(){
        assertThrows(FileNotFoundException.class, () -> service.read("asdf"));
    }

    @Test
    public void testReadForValidPath(){
        String path = getClass().getClassLoader().getResource("stopwords.txt").getFile();

        assertDoesNotThrow(() -> {
            final String read = service.read(path);
            assertNotNull(read);
            assertFalse(read.isEmpty());
        });
    }
}