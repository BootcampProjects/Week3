package org.kodluyoruz.trendyol;

import java.util.HashSet;
import java.util.Objects;

public class UniqueWordCounter {
    public int getUniqueWordCount(String phrase) {

        if (Objects.isNull(phrase))
            throw new IllegalArgumentException("Phrase must not be null.");

        phrase = phrase.trim();

        if (phrase.equals(""))
            return 0;

        phrase = phrase.replace(".", "").replace(",", "");

        String[] words = phrase.split(" ");

        HashSet<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }

        return uniqueWords.size();
    }
}
