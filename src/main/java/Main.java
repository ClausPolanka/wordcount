import exceptions.FormatException;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args){

        ScannerInput scannerInput = new ScannerInput();
        try {
            scannerInput.start();
        } catch (FileNotFoundException | FormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
