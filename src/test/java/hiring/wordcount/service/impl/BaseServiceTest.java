package hiring.wordcount.service.impl;

import hiring.wordcount.service.BaseService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseServiceTest {

    protected void getServiceName(BaseService service) {
        assertNotNull(service.getServiceName());
        assertFalse(service.getServiceName().isEmpty());
    }

}
