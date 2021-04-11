package word.op;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import word.ui.IReader;
import word.ui.IWriter;

public class WordInformationTest {

	WordInformation winfo;
	 
    @Test
    public void WHEN_empty_input_THEN_return_0() {
    	Reader reader = new Reader("");
    	Writer writer = new Writer();
    	winfo = new WordInformation( );
		assertEquals(0, winfo.getWordCount(reader.getText()));
		writer.message = String.format("Number of words: %d",winfo.getWordCount(reader.getText()));
		assertEquals("Number of words: 0", writer.message);
   }
    
    @Test
    public void WHEN_valid_input_THEN_return_Size() {
    	Reader reader = new Reader("Mary had a little lamb");
    	Writer writer = new Writer();
    	winfo = new WordInformation( );
		assertEquals(5, winfo.getWordCount(reader.getText()));
		writer.message = String.format("Number of words: %d",winfo.getWordCount(reader.getText()));
		assertEquals("Number of words: 5", writer.message);
   }
    
    @Test
    public void WHEN_invalid_input_THEN_return_0() {
    	Reader reader = new Reader(" %%  ## a# #  #&&");
    	Writer writer = new Writer();
    	winfo = new WordInformation();
		assertEquals(0, winfo.getValidWords(reader.getText()).size());
		writer.message = String.format("Number of words: %d",winfo.getWordCount(reader.getText()));
		assertEquals("Number of words: 0", writer.message);
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
