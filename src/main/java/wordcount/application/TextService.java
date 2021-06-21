package wordcount.application;

import wordcount.domain.IWordCounter;
import wordcount.domain.WordCounter;
import wordcount.io.ITextReader;
import wordcount.io.TextReader;

import java.io.InputStreamReader;

public class TextService implements ITextService {


    @Override
    public long count() {

        System.out.println("Write your text: \n");
        ITextReader textReader = new TextReader(new InputStreamReader(System.in));

        IWordCounter wordCounter = new WordCounter();

        return wordCounter.countWords(textReader.readText());

    }
}
