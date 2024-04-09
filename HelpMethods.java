/*
 * Author: Zhao Tong(zhao.tong@ucdconnect.ie)
 * This code is complete
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HelpMethods {
    public static int[] generateDataset(int length) {
        int[] dataset = new int[length];

        Random random = new Random();
        random.setSeed(12348);

        for (int i = 0; i < length; i++) {
            dataset[i] = random.nextInt(20001) - 10000;
        }

        return dataset;
    }

    /**
     * check the sorted array by its length, order and occurrence of each char
     * @param originalArray original
     * @param sortedArray sorted
     * @return true or false
     */
    public static boolean verifyCorrectness(int[] originalArray, int[] sortedArray) {
        // Check if both arrays have the same length
        if (originalArray.length != sortedArray.length) {
            return false;
        }

        // Check if the sorted array is in non-decreasing order
        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (sortedArray[i] > sortedArray[i + 1]) {
                return false;
            }
        }

        // Count occurrences in both arrays
        Map<Integer, Integer> originalCounts = new HashMap<>();
        Map<Integer, Integer> sortedCounts = new HashMap<>();

        for (int i = 0; i < originalArray.length; i++) {
            originalCounts.put(originalArray[i], originalCounts.getOrDefault(originalArray[i], 0) + 1);
            sortedCounts.put(sortedArray[i], sortedCounts.getOrDefault(sortedArray[i], 0) + 1);
        }

        // Compare occurrences of each element in both arrays
        for (int number : originalCounts.keySet()) {
            if (!originalCounts.get(number).equals(sortedCounts.get(number))) {
                return false;
            }
        }

        // If all checks pass, the array is correctly sorted
        return true;
    }

    public static void printDataset(int[] dataset) {
        int length = Math.min(dataset.length, 15);
        for (int i = 0; i < length; i++) {
            System.out.println(dataset[i]);
        }
        System.out.println("\n");
    }
}
