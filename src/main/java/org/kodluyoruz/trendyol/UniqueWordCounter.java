package org.kodluyoruz.trendyol;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueWordCounter {
    public int getUniqueWordCount(String phrase) {

        String[] words = phrase.split(" ");

        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        return uniqueWords.size();
    }
}
