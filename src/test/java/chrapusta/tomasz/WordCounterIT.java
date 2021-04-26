package chrapusta.tomasz;

import chrapusta.tomasz.repository.FileStructureRepositorySpy;
import chrapusta.tomasz.repository.WordCounterProvider;
import chrapusta.tomasz.repository.WordRepositorySpy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordCounterIT {

    private WordCounterApplication sut;
    private WordRepositorySpy wordRepositorySpy;
    private FileStructureRepositorySpy fileStructureRepositorySpy;

    @BeforeEach
    private void setupSut() {
        wordRepositorySpy = new WordRepositorySpy();
        fileStructureRepositorySpy = new FileStructureRepositorySpy();
        WordCounterProvider wordCounterProvider = new WordCounterProvider(wordRepositorySpy, fileStructureRepositorySpy);
        sut = new WordCounterApplication(wordRepositorySpy, fileStructureRepositorySpy, wordCounterProvider);
    }

    @Test
    public void countWordsInStringWithThreeWordsIsThree() throws Exception {
        //GIVEN
        String[] input = new String[]{"word     wor%d            wo3d 3 % anotherWord \\n lastWord"};
        //wordRepositorySpy.setValidatedInput(input);
        //WHEN
        sut.execute(input);
        //THEN
        Assertions.assertEquals(wordRepositorySpy.getCountWords(), 3);
    }

    @Test
    public void countWordsIsIgnoringStopWords() throws Exception {
        //GIVEN
        String[] input = new String[]{"word the  a  on   off "};
        //wordRepositorySpy.setValidatedInput(input);
        //WHEN
        sut.execute(input);
        //THEN
        Assertions.assertEquals(wordRepositorySpy.getCountWords(), 1);
    }

}
