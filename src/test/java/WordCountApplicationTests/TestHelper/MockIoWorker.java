package WordCountApplicationTests.TestHelper;

import WordCountApplication.Controller.Interfaces.IOWorker;

import java.util.ArrayList;
import java.util.List;

public class MockIoWorker implements IOWorker {

    private List<String> mockInput;
    private List<String> mockUpFile;
    private String mockLine;

    public void setMockUpFile(List<String> mockUpFile) {
        this.mockUpFile = mockUpFile;
    }

    public void setMockInput(List<String> mockInput) {
        this.mockInput = mockInput;
    }

    public void setMockLine(String mockLine) {
        this.mockLine = mockLine;
    }

    @Override
    public String singleLineReader() {
        return mockLine;
    }

    @Override
    public List<String> readFromConsole() {
        return mockInput;
    }

    @Override
    public List<String> fileReader(String fileName) {
        if (fileName.isEmpty()) {
            return new ArrayList<String>();
        }
        if (!fileName.contains("stop_words.txt") && !mockUpFile.isEmpty()) {
            return mockUpFile;
        }
        return new ArrayList<String>() {
            {
                add("test");
                add("mock");
            }
        };
    }
}
