package hiring.wordcount.app;

import hiring.wordcount.service.InputReaderService;
import hiring.wordcount.service.ParserService;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public class WordCountApplication {
    private static String INPUT_READER_SERVICE = "StandardIOService";
    private static String PARSER_SERVICE = "WordParserService";

    public static void main(String[] args) {
        ServiceLoader<InputReaderService> inputReaderServiceServiceLoader =
                ServiceLoader.load(InputReaderService.class);
        final Iterator<InputReaderService> inputReaderServiceIterator = inputReaderServiceServiceLoader.iterator();
        while (inputReaderServiceIterator.hasNext()) {
            final InputReaderService inputReaderService = inputReaderServiceIterator.next();
            if (inputReaderService.getServiceName().equalsIgnoreCase(INPUT_READER_SERVICE)) {

                ServiceLoader<ParserService> serviceLoader = ServiceLoader.load(ParserService.class);
                final Iterator<ParserService> parserServiceIterator = serviceLoader.iterator();
                while (parserServiceIterator.hasNext()) {
                    final ParserService parserService = parserServiceIterator.next();
                    if (parserService.getServiceName().equalsIgnoreCase(PARSER_SERVICE)) {

                        try {
                            final String line = inputReaderService.read(null);
                            final List<String> wordsAsList = parserService.getWordsAsList(line);

                            System.out.println("Number of words: " + wordsAsList.size());

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }

    }
}
