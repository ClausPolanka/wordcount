package chrapusta.tomasz;

import chrapusta.tomasz.repository.WordRepositorySpy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordCounterIT {

    private WordCounterApplication sut;
    private WordRepositorySpy repository;

    @BeforeEach
    private void setupSut() {
        repository = new WordRepositorySpy();
        sut = new WordCounterApplication(repository);
    }

    @Test
    public void countWordsInStringWithThreeWordsIsThree() {
        //GIVEN
        String[] input = new String[]{"word     wor%d            wo3d 3 % anotherWord \\n lastWord"};
        repository.setValidatedInput(input);
        //WHEN
        sut.execute();
        //THEN
        Assertions.assertEquals(repository.getCountWords(), 3);
    }

}
