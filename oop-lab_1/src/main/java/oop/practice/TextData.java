package oop.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextData {
    private String fileName; // Corrected to camelCase
    private String text;
    private int numberOfVowels = 0;
    private int numberOfConsonants = 0;
    private int numberOfLetters = 0;
    private int numberOfSentences = 0;
    private String longestWord = "";

    // Constructor to initialize the text
    public TextData(String text) {
        this.text = text;
        this.fileName = ""; // Initialize fileName if needed
        analyzeText();
    }

    // Method to analyze the text and calculate statistics
    private void analyzeText() {
        // Regular expressions for analysis
        Pattern vowelPattern = Pattern.compile("[aeiouAEIOU]");
        Pattern consonantPattern = Pattern.compile("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]");
        Pattern letterPattern = Pattern.compile("[a-zA-Z]");
        Pattern sentencePattern = Pattern.compile("[.!?]");
        Pattern wordPattern = Pattern.compile("\\b\\w+\\b");

        // Analyze the text
        Matcher matcher;

        // Count vowels, consonants, and letters
        for (char c : text.toCharArray()) {
            if (vowelPattern.matcher(String.valueOf(c)).find()) {
                numberOfVowels++;
            } else if (consonantPattern.matcher(String.valueOf(c)).find()) {
                numberOfConsonants++;
            }
            if (letterPattern.matcher(String.valueOf(c)).find()) {
                numberOfLetters++;
            }
        }

        // Count sentences
        matcher = sentencePattern.matcher(text);
        while (matcher.find()) {
            numberOfSentences++;
        }

        // Find the longest word
        matcher = wordPattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
    }
    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() {
        return longestWord;
    }
}
