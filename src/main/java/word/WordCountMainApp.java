package word;

import word.op.WordInformation;
import word.ui.ConsoleWriter;
import word.ui.IReader;
import word.ui.IWriter;
import word.ui.ReaderFactory;

public class WordCountMainApp {

	
	
	public static void main(String[] args) {
		IWriter print = new ConsoleWriter();
		print.writeText("Enter the text:");
		IReader input = ReaderFactory.getReader(args);
		 WordInformation info = new WordInformation();
		print.writeText(String.format("Number of words: %d",Integer.toString(info.getWordCount(input.getText()))));
	}

}
