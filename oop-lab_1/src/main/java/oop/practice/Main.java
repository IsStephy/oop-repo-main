package oop.practice;




public class Main {
    public static void main(String[] args) {
        FileReader readFile = new FileReader();
        String path = args[0];
        String fileContent = readFile.readFileIntoString(path);
        TextData text = new TextData(fileContent);
        System.out.println("Number of Vowels: " + text.getNumberOfVowels());
        System.out.println("Number of Consonants: " + text.getNumberOfConsonants());
        System.out.println("Number of Letters: " + text.getNumberOfLetters());
        System.out.println("Number of Sentences: " + text.getNumberOfSentences());
        System.out.println("Longest Word: " + text.getLongestWord());

        for(int i = 1; i <= args.length-1; i++) {
            path = args[i];
            fileContent = readFile.readFileIntoString(path);
            text = new TextData(fileContent);
            System.out.println("Number of Vowels: " + text.getNumberOfVowels());
            System.out.println("Number of Consonants: " + text.getNumberOfConsonants());
            System.out.println("Number of Letters: " + text.getNumberOfLetters());
            System.out.println("Number of Sentences: " + text.getNumberOfSentences());
            System.out.println("Longest Word: " + text.getLongestWord());

        }
    }
}
