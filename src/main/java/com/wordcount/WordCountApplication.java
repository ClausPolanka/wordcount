package com.wordcount;


import com.wordcount.counter.Counter;
import com.wordcount.counter.CounterImpl;
import com.wordcount.dto.CounterDto;
import com.wordcount.filter.StopwordFilterImpl;
import com.wordcount.io.InputOutputHelper;
import com.wordcount.reader.StopwordReaderImpl;

public class WordCountApplication {

    public static void main(String args[]) {
        Counter counter = new CounterImpl(new StopwordFilterImpl(new StopwordReaderImpl()));
        InputOutputHelper inputOutputHelper = new InputOutputHelper();

        String input = inputOutputHelper.read(args);

        CounterDto counterDto = counter.countWords(input);
        inputOutputHelper.write(counterDto);
    }

}
