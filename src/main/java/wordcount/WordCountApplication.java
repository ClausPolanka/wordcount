package wordcount;

import wordcount.application.ITextService;
import wordcount.application.TextServiceFacade;
import wordcount.io.WordCountPrinter;

public class WordCountApplication {


        public static void main(String ...args) {

                ITextService textService = new TextServiceFacade();

                WordCountPrinter.printCount(textService.count());

        }


}
