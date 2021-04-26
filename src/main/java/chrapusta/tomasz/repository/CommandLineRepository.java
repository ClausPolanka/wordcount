package chrapusta.tomasz.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineRepository implements WordRepository {

    @Override
    public String getInput() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        }
    }

    @Override
    public void writeCount(long countWords) {
        System.out.println("Count words is equal: " + countWords);
    }

}
