package chrapusta.tomasz;

import chrapusta.tomasz.repository.StopWordsRepositorySpy;
import chrapusta.tomasz.repository.WordRepositorySpy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordCounterIT {

    private WordCounterApplication sut;
    private WordRepositorySpy wordRepositorySpy;
    private StopWordsRepositorySpy stopWordsRepositorySpy;

    @BeforeEach
    private void setupSut() {
        wordRepositorySpy = new WordRepositorySpy();
        stopWordsRepositorySpy = new StopWordsRepositorySpy();
        sut = new WordCounterApplication(wordRepositorySpy, stopWordsRepositorySpy);
    }

    @Test
    public void countWordsInStringWithThreeWordsIsThree() throws Exception {
        //GIVEN
        String[] input = new String[]{"word     wor%d            wo3d 3 % anotherWord \\n lastWord"};
        wordRepositorySpy.setValidatedInput(input);
        //WHEN
        sut.execute();
        //THEN
        Assertions.assertEquals(wordRepositorySpy.getCountWords(), 3);
    }

    @Test
    public void countWordsIsIgnoringStopWords() throws Exception {
        //GIVEN
        String[] input = new String[]{"word the  a  on   off "};
        wordRepositorySpy.setValidatedInput(input);
        //WHEN
        sut.execute();
        //THEN
        Assertions.assertEquals(wordRepositorySpy.getCountWords(), 1);
    }

}
