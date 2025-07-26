import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        // Change the file path as per your system
        String filePath = "sample.txt";

        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Remove punctuation, convert to lowercase, split by whitespace
                String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            System.out.println("Word Frequencies:");
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
