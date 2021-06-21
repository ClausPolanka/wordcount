package wordcount;

import utils.ResourceFetcher;
import wordcount.application.ITextService;
import wordcount.application.TextServiceFacade;
import wordcount.io.WordCountPrinter;

import java.util.Optional;

public class WordCountApplication {


    public static void main(String... args) {

        ResourceFetcher resourceFetcher = new ResourceFetcher();

        ITextService textService = new TextServiceFacade(resourceFetcher);

        if (args.length > 0) {
            WordCountPrinter.printCount(textService.count(Optional.of(args[0])));
        } else {
            WordCountPrinter.printCount(textService.count(Optional.ofNullable(null)));
        }


    }


}
