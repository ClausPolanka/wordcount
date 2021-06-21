package wordcount.application;

import utils.ResourceFetcher;
import wordcount.domain.IWordCounter;
import wordcount.domain.WordCounter;
import wordcount.error.WrappedException;
import wordcount.io.ErrorCode;
import wordcount.io.ITextReader;
import wordcount.io.StopwordReader;
import wordcount.io.TextReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Optional;

public class TextServiceFacade implements ITextService {

    ResourceFetcher resourceFetcher;

    public TextServiceFacade(ResourceFetcher resourceFetcher) {
        this.resourceFetcher = resourceFetcher;
    }


    @Override
    public WordCounter.CountResult count(Optional<String> fileName) {

        WordCounter.CountResult result;

        if (isAbsent(fileName)) {
            InputStreamReader isr = new InputStreamReader(System.in);
            result = countFromConsole(isr);
        } else {
            File file = resourceFetcher.getFileFromResources(fileName, ErrorCode.ERRORS_ACCESSING_RESOURCE_TEXT_SERVICE_FACADE);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                result = countFromFile(new InputStreamReader(fileInputStream));
            } catch (FileNotFoundException e) {
                throw new WrappedException(ErrorCode.FILE_CANNOT_BE_NULL_TEXT_SERVICE_FACADE.name());
            }
        }
        return result;
    }


    private boolean isAbsent(Optional<String> fileName) {
        return !fileName.isPresent();
    }

    WordCounter.CountResult countFromConsole(InputStreamReader isr) {
        System.out.println("Write your text: \n");

        return computeCount(isr);
    }

    private WordCounter.CountResult computeCount(InputStreamReader is) {
        ITextReader textReader = new TextReader(is);

        StopwordReader stopwordReader = new StopwordReader(resourceFetcher);
        var stopwordList = Optional.of(stopwordReader.readStopwords()).orElse(Collections.emptyList());

        IWordCounter wordCounter = new WordCounter();

        return wordCounter.countWords(textReader.readText(), stopwordList);
    }

    WordCounter.CountResult countFromFile(InputStreamReader is) {
        return computeCount(is);
    }


}
