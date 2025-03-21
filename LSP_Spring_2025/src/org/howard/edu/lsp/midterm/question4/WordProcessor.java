package org.howard.edu.lsp.midterm.question4;

import java.util.*;

/**
 * WordProcessor class for processing sentences and finding their longest words.
 */
public class WordProcessor {
    private String sentence;

    /**
     * 
     * @param sentence
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Find the longest words in a sentence
     * 
     * @return a list of the longest words
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();

        // Split sentence into words
        String[] words = sentence.trim().split("\\s+");

        // Find the length of the longest word
        int maxLength = 0;
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        // Collect all words with the maximum length, preserving order
        for (String word : words) {
            if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }
}