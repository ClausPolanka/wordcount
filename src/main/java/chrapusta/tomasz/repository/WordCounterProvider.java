package chrapusta.tomasz.repository;

import chrapusta.tomasz.ParamsValidator;

import java.io.IOException;
import java.net.URISyntaxException;

public class WordCounterProvider {

    private final WordRepository wordRepository;
    private final FileStructureRepository fileStructureRepository;

    public WordCounterProvider(final WordRepository wordRepository,
                               final FileStructureRepository fileStructureRepository) {
        this.wordRepository = wordRepository;
        this.fileStructureRepository = fileStructureRepository;
    }


    public String provideWord(String[] args) throws IOException, URISyntaxException {
        String word;
        if (ParamsValidator.areParamsProvided(args)) {
            String fileName = args[0];
            word = fileStructureRepository.readFile(fileName);
        } else {
            word = wordRepository.getInput();
        }
        return word;
    }
}
