package word.op;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import word.ui.ConsoleWriter;
import word.ui.FileReader;
import word.ui.IReader;
import word.ui.IWriter;

public class WordInformationTest {

	WordInformation winfo;
	StopWords stopWords ;
	  
 
    @Test
    public void WHEN_getWordsFromFile_THEN_return_size() {
     	Writer writer = new Writer();
    	FileReader fileReaderstops = new FileReader("stopwords.txt");
    	FileReader fileReaderWords = new FileReader("mytext.txt");
    	stopWords = new StopWords(fileReaderWords);
    	
		 winfo = new WordInformation(stopWords);
		assertEquals(4, winfo.getValidWordsWitoutStopWords(fileReaderstops.getText()).size());
		writer.message = String.format("Number of words: %d",winfo.getValidWordsWitoutStopWords(fileReaderWords.getText()).size());
		assertEquals("Number of words: 4", writer.message);
   }
    
  
    
    static class Reader implements IReader{
      	String text;
    	public Reader(String text) {
    		this.text= text;
    	}
		@Override
		public String getText() {
			 
			return text;
		}
    	
    }
    
    static class Writer implements IWriter{
   
    	String message;
    	
		@Override
		public void writeText(String message) {
			// TODO Auto-generated method stub
			this.message = message;
		}
    	
    }
}
