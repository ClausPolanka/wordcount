package io;

import org.apache.commons.lang3.StringUtils;
import util.FileReader;

import java.util.List;

public class FileBasedUI extends  ConsoleIO{

    private String fileName;

    public FileBasedUI(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getInput() {

        final List<String> lines = FileReader.getWordsFromFile(fileName);

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0; i<lines.size(); i++) {

            stringBuilder.append(lines.get(i));
            stringBuilder.append(StringUtils.SPACE);

        }

        return stringBuilder.toString();

        }

}
