package word.ui;

public class ConsoleWriter implements IWriter{

	@Override
	public void writeText(String text) {		 
		System.out.println(text);
	}

}
