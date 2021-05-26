package wordcount.iosupport;

public class SpyConsoleAdapter implements ConsoleInterface {

	private final String input;
	private String output = "";

	public SpyConsoleAdapter(String input) {
		super();
		this.input = input;
	}

	@Override
	public String readFromConsole() {
		return input;
	}

	@Override
	public void printToConsole(String string) {
		this.output = String.format("%s%s%n", this.output, string);
	}

	public String getInput() {
		return input;
	}

	public String getOutput() {
		return output;
	}

}
