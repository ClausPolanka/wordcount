package wordcount.application;

import wordcount.domain.IWordCounter;
import wordcount.domain.WordCounter;
import wordcount.error.WrappedException;
import wordcount.io.Errors;
import wordcount.io.ITextReader;
import wordcount.io.StopWordReader;
import wordcount.io.TextReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Optional;

public class TextServiceFacade implements ITextService {
      
    @Override
    public long count(Optional<String> fileName)  {

        long result;

        if (isAbsent(fileName)) {
        InputStreamReader isr = new InputStreamReader(System.in);
           result =  countFromConsole(isr);
        } else  {
            URL resource = StopWordReader.class.getClassLoader().getResource(fileName.get());
            File file;
            try {
                file = Paths.get(resource.toURI()).toFile();

            }
            catch(URISyntaxException ex) {
                throw new WrappedException(Errors.ERRORS_ACCESSING_RESOURCE_STOPWORD_READER.name());
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                result = countFromFile(new InputStreamReader(fileInputStream));
            } catch (FileNotFoundException e) {
              throw new WrappedException(Errors.FILE_CANNOT_BE_NULL_TEXT_SERVICE_FACADE.name());
            }
        }
        return result;
    }

    private boolean isAbsent(Optional<String> fileName) {
        return !fileName.isPresent();
    }

    long countFromConsole(InputStreamReader isr) {
        System.out.println("Write your text: \n");

         return computeCount(isr);
     }

    private long computeCount(InputStreamReader is) {
        ITextReader textReader = new TextReader(is);

        StopWordReader stopWordReader = new StopWordReader();
        var stopwordList = Optional.of(stopWordReader.readStopWords()).orElse(Collections.emptyList());

        IWordCounter wordCounter = new WordCounter();

        return wordCounter.countWords(textReader.readText(), stopwordList);
    }

    long countFromFile(InputStreamReader is) {
        return computeCount(is);
    }
    

}
