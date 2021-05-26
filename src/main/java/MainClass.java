import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
	
	public static void main(String ...args) throws IOException {
		
		System.out.print("Enter text: ");
		
		BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
		String input = reader.readLine();
		
		int result = new WordCounter().countWords(input);
			
		System.out.print("Number of words: "+result);
	}
	
}
