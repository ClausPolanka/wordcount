package WordCountApplicationTests.TestHelper;

import WordCountApplication.Controller.Interfaces.IOWorker;

import java.util.List;

public class MockIoWorker implements IOWorker {

    private List<String> mockInput;

    public void setMockInput(List<String> mockInput) {
        this.mockInput = mockInput;
    }

    @Override
    public List<String> readFromConsole() {
        return mockInput;
    }
}
