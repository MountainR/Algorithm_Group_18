/**
 * Author: Zhao Tong(zhao.tong@ucdconnect.ie)
 * This code is complete
 */
import java.util.Random;
import java.util.Stack;

public class NonRecursiveQuickSort {
    private static final Random rand = new Random();

    public static void sort(int[] array, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            if (high <= low) {
                continue;
            }

            int pivotIndex = partition(array, low, high);
            stack.push(low);
            stack.push(pivotIndex - 1);
            stack.push(pivotIndex + 1);
            stack.push(high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // Choose a random pivot to avoid the worst-case scenario
        int pivotIndex = low + rand.nextInt(high - low + 1);
        swap(array, pivotIndex, high);
        int pivot = array[high];

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
