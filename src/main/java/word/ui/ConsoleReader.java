package word.ui;

import java.util.Scanner;

public class ConsoleReader implements IReader {
 
	@Override
	public String getText() {
		 try (Scanner input = new Scanner(System.in)) {
            return input.nextLine();
        }
 	}
	
	
}
