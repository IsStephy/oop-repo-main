package oop.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    // Method to read the contents of a file and return it as a String
    public String readFileIntoString(String path) {
        StringBuilder content = new StringBuilder();

        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                content.append(data).append(System.lineSeparator()); // Add a new line after each line
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        return content.toString(); // Convert StringBuilder to String
    }

}
