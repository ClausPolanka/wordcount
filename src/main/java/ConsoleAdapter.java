import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleAdapter implements ConsoleInterface {

	@Override
	public String readFromConsole() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			return reader.readLine();
		} catch (IOException e) {
			return "";
		}
	}

	@Override
	public void printToConsole(String string) {
		System.out.println(string);
	}

}
