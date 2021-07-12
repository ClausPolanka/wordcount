package com.wordcount;

import java.io.File;
import java.io.InputStreamReader;
import java.util.*;

public class InputTextFileImpl implements InputUser{
    private static final String PATH_INPUT_TEXT = "src/resources/";

    @Override
    public String getUserInput() {

        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Enter file name: ");
        String fileName = scanner.nextLine();
        if (fileName != null) {
            File inputFile = new File(PATH_INPUT_TEXT + fileName);
            if (inputFile.exists()) {
                return inputFile.getAbsolutePath();
            }
            else{
                return null;
            }
        }
        else    {
            return  null;
        }
    }


}
