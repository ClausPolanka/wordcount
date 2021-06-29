import exceptions.FormatException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FileOpenerTests {

    private static final String NON_EXISTING_FILE = "file.txt";

    private static final String WRONG_FILE_FORMAT = "file.jpg";

    private static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    private static final String STOP_WORD_THE = "the";

    private static final String STOP_WORD_A = "a";

    private static final String STOP_WORD_ON = "on";

    private static final String STOP_WORD_OFF = "off";

    private FileOpener fileOpener;

    @Before
    public void init(){
        this.fileOpener = new FileOpener();
    }

    @Test (expected = FileNotFoundException.class)
    public void checkWithNullFileShouldThrowAnException() throws FileNotFoundException, FormatException {

        fileOpener.openTextFileFromResources(null);
    }

    @Test (expected = FileNotFoundException.class)
    public void checkWithNonExistingFileShouldThrowAnException() throws FileNotFoundException, FormatException {

        fileOpener.openTextFileFromResources(NON_EXISTING_FILE);
    }

    @Test (expected = FormatException.class)
    public void checkWithWrongFileFormatShouldThrowAnException() throws FileNotFoundException, FormatException {

        fileOpener.openTextFileFromResources(WRONG_FILE_FORMAT);
    }

    @Test
    public void readLinesFromTextFile() throws FileNotFoundException, FormatException {
        
        List<String> stopWordList = new ArrayList<>();
        List<String> returnedList = fileOpener.openTextFileFromResources(STOP_WORDS_FILE_NAME);

        stopWordList.add(STOP_WORD_THE);
        stopWordList.add(STOP_WORD_A);
        stopWordList.add(STOP_WORD_ON);
        stopWordList.add(STOP_WORD_OFF);

        for (String stopWord : stopWordList){
            Assert.assertTrue(returnedList.contains(stopWord));

            returnedList.remove(stopWord);
        }

        Assert.assertTrue(returnedList.isEmpty());
    }
}
