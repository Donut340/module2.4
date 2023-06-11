import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueWordCounter {
    public static void main(String[] args) {
        // Create a Set to store unique words
        Set<String> uniqueWords = new HashSet<>();

        try {
            // Create a Scanner to read the text file
            Scanner scanner = new Scanner(new File("test.txt"));

            // Iterate through each line in the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Split the line into words using whitespace as the delimiter
                String[] words = line.split("\\s+");

                // Process each word
                for (String word : words) {
                    // Remove punctuation and convert to lowercase
                    String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    // Add the clean word to the Set (if it's not empty)
                    if (!cleanWord.isEmpty()) {
                        uniqueWords.add(cleanWord);
                    }
                }
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Print the number of unique words
        System.out.println("Number of unique words: " + uniqueWords.size());
    }
}
