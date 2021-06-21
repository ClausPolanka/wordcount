package wordcount.application;

import wordcount.domain.IWordCounter;
import wordcount.domain.WordCounter;
import wordcount.io.ITextReader;
import wordcount.io.StopWordReader;
import wordcount.io.TextReader;

import java.io.InputStreamReader;

public class TextServiceFacade implements ITextService {


    @Override
    public long count() {

        System.out.println("Write your text: \n");
        ITextReader textReader = new TextReader(new InputStreamReader(System.in));

        StopWordReader stopWordReader = new StopWordReader();
        var stopwordList = stopWordReader.readStopWords();

        IWordCounter wordCounter = new WordCounter();

        return wordCounter.countWords(textReader.readText());

    }
}
