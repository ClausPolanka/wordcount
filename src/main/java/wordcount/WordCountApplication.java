package wordcount;

import wordcount.application.ITextService;
import wordcount.application.TextServiceFacade;
import wordcount.io.WordCountPrinter;

import java.util.Optional;

public class WordCountApplication {


    public static void main(String... args) {

        ITextService textService = new TextServiceFacade();

        if (args.length > 0) {
            WordCountPrinter.printCount(textService.count(Optional.of(args[0])));
        } else {
            WordCountPrinter.printCount(textService.count(Optional.ofNullable(null)));
        }


    }


}
