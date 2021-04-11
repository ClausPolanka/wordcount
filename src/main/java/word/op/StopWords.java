package word.op;

 
import java.util.Collections;
import java.util.List;

import word.ui.FileReader;

public class StopWords {
	
	private List<String> stopWords = Collections.<String>emptyList();  

  public StopWords(FileReader fileReader) {
	 stopWords= fileReader.getLineWords();
 }
	public List<String> getStopWords() {
		return stopWords;
	}
	 
}
