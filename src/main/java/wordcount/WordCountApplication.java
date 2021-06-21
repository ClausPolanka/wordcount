package wordcount;

import wordcount.application.ITextService;
import wordcount.application.TextService;
import wordcount.io.WordCountPrinter;

public class WordCountApplication {


        public static void main(String ...args) {

                ITextService textService = new TextService();

                WordCountPrinter.printCount(textService.count());

        }


}
