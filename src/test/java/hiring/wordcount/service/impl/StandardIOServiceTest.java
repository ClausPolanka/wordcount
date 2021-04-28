package hiring.wordcount.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class StandardIOServiceTest extends BaseServiceTest{

    private StandardIOService service;
    private static String SERVICE_NAME = "StandardIOService";

    @BeforeEach
    public void setUp(){
        service = new StandardIOService();
    }

    @Test
    public void testName(){
        super.getServiceName(service);
    }

    @Test
    public void testReadWithNull(){
        testReadNotEmpty(null);
        testReadEmpty(null);
    }

    @Test
    public void testReadWithNotNull(){
        testReadNotEmpty("null");
        testReadEmpty("null");
    }

    private void testReadNotEmpty(String param){
        assertDoesNotThrow(() -> {
            System.setIn(new ByteArrayInputStream("test test test".getBytes(StandardCharsets.UTF_8)));
            final String read = service.read(param);

            assertNotNull(read);
            assertFalse(read.isEmpty());
        });
    }

    private void testReadEmpty(String param){
        assertDoesNotThrow(() -> {
            System.setIn(new ByteArrayInputStream("".getBytes(StandardCharsets.UTF_8)));
            final String read = service.read(param);

            assertNotNull(read);
            assertTrue(read.isEmpty());
        });
    }
}