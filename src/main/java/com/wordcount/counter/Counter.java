package com.wordcount.counter;

import com.wordcount.dto.CounterDto;

public interface Counter {

    CounterDto countWords(String text);

}
