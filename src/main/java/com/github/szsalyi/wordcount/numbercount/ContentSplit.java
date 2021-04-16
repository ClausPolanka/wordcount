package com.github.szsalyi.wordcount.numbercount;

import java.util.List;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public interface ContentSplit {
    List<String> stringList(String inputContent);
}
