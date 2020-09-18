package org.kodluyoruz.trendyol;

import java.util.HashSet;

public class UniqueWordCounter {
    public int getUniqueWordCount(String phrase) {

        phrase = phrase.replace(".", "").replace(",", "");

        String[] words = phrase.split(" ");

        HashSet<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }

        return uniqueWords.size();
    }
}
