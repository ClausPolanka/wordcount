package word.ui;

public class ReaderFactory {

	
	public static IReader getReader(String []a) {
		if(a.length>0) {
			return new ConsoleReader();
		}else {
			return null;
		}
		 
	}
}
