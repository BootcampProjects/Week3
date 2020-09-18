package org.kodluyoruz.trendyol;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class UniqueWordCounter {
    public int getUniqueWordCount(String phrase) {

        if (Objects.isNull(phrase))
            throw new IllegalArgumentException("Phrase must not be null.");

        String modifiedPhrase = phrase.trim().toLowerCase().replace(".", "").replace(",", "");

        if (modifiedPhrase.equals(""))
            return 0;

        String[] words = modifiedPhrase.split("\\s+");
        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        return uniqueWords.size();
    }
}
