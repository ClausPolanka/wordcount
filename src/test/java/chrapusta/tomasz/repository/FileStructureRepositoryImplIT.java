package chrapusta.tomasz.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class FileStructureRepositoryImplIT {

    @Test
    public void isAbleToReadStopWordsFromFile() throws IOException, URISyntaxException {
        //GIVEN
        FileStructureRepository sut = new FileStructureRepositoryImpl();
        //WHEN
        Set<String> stopWords = sut.readAllLines("/stopwords.txt");
        //THEN
        List<String> expected = Arrays.asList("the", "a", "on", "off");
        Assertions.assertTrue(stopWords.containsAll(expected) && expected.containsAll(stopWords));
    }
}
