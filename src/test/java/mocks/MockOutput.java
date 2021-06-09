package mocks;

import root.service.OutputInterface;

public class MockOutput implements OutputInterface {

    private StringBuilder sb = new StringBuilder();

    @Override
    public void print(String text) {
        sb.append(text);
    }

    public String getText() {
        return sb.toString();
    }
}
