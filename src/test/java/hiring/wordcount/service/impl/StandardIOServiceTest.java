package hiring.wordcount.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StandardIOServiceTest extends BaseServiceTest {

    private static String SERVICE_NAME = "StandardIOService";
    private StandardIOService service;

    @BeforeEach
    public void setUp() {
        service = new StandardIOService();
    }

    @Test
    public void testName() {
        super.getServiceName(service);
    }

    private void testReadEmpty(String param) {
        assertDoesNotThrow(() -> {
            System.setIn(new ByteArrayInputStream("\n".getBytes(StandardCharsets.UTF_8)));
            final String read = service.read(param);

            assertNotNull(read);
            assertTrue(read.isEmpty());
        });
    }

    private void testReadNotEmpty(String param) {
        assertDoesNotThrow(() -> {
            System.setIn(new ByteArrayInputStream("test test test".getBytes(StandardCharsets.UTF_8)));
            final String read = service.read(param);

            assertNotNull(read);
            assertFalse(read.isEmpty());
        });
    }

    @Test
    public void testReadWithNotNull() {
        testReadNotEmpty("null");
        testReadEmpty("null");
    }

    @Test
    public void testReadWithNull() {
        testReadNotEmpty(null);
        testReadEmpty(null);
    }
}