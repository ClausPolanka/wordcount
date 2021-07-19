import java.util.Scanner;

public class InputInterface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = scanner.nextLine();

        Foo f = new Foo();
        int wordCount = f.countWords(text);

        System.out.println("Number of words: " + wordCount);
    }
}
