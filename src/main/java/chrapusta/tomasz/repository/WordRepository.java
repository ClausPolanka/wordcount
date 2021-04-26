package chrapusta.tomasz.repository;

import java.io.IOException;

public interface WordRepository {

    String getInput() throws IOException;

    void writeCount(long countWords);
}
