package wordcount.application;

import wordcount.domain.WordCounter;

import java.util.Optional;

public interface ITextService {

    public WordCounter.CountResult count(Optional<String> fileName);

}
