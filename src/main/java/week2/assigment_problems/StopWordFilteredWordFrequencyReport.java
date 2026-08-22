package week2.assigment_problems;

import java.util.*;

public class StopWordFilteredWordFrequencyReport {

    public static void generateReport(String text, Set<String> stopWords) {

        text = text.toLowerCase();
        text = text.replace(".", "");

        String[] words = text.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            if (!stopWords.contains(word)) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        String text = "This is a simple test. This test is simple.";

        Set<String> stopWords = new HashSet<>();

        stopWords.add("this");
        stopWords.add("is");
        stopWords.add("a");

        generateReport(text, stopWords);
    }
}