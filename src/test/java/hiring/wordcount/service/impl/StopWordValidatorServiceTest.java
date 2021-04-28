package hiring.wordcount.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StopWordValidatorServiceTest extends BaseServiceTest{

    StopWordValidatorService service;

    @BeforeEach
    public void setUp() {
        service = new StopWordValidatorService();
    }

    @Test
    public void testName() {
        super.getServiceName(service);
    }

    @Test


}