package org.kodluyoruz.trendyol;

public class UniqueWordCounter {
    public int getUniqueWordCount(String phrase) {

        String[] words = phrase.split(" ");

        return words.length;
    }
}
