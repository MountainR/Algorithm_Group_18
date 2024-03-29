import java.util.Arrays;

/**
 * Author: Rui Li(rui.li@ucdconnect.ie)
 * MSQSA helper
 * MSQSA does not need division part in merge sort.
 * Instead, it needs to sort 2 subarrays within an array(merge them) based on given indexes
 * 
 */
public class NonRecursiveMergeSort {
    /**
     * merge method sorts two subarrays within array(merge them in sorted manner)
     * subarray 1: array[start, middle-1]
     * subarray 2: array[middle, end]
     * @param array The whole array
     * @param start starting index of subarray 1
     * @param middle starting index of subarray 2
     * @param end ending index of subarray 2
     */
    public static void merge(int[] array, int start, int middle, int end) {
        // get two subarrays
        int[] left_array = Arrays.copyOfRange(array, start, middle-1);
        int[] right_array = Arrays.copyOfRange(array, middle, end);

        // pointers to the beginning of subarrays
        int left_index = 0;                  // start of subarray 1
        int right_index = 0;                  // start of subarray 2
        // a pointer to the original array
        int index = start;

        // merge arrays



    }

    public static void main(String[] args) {
        /* make sure int[] points to an object and Java passes object by reference
        int[] arr = {1, 2};
        merge(arr, 0, 1, 2);
        System.out.println(Arrays.toString(arr)); // print 2
        */

        int[] array = {1, 3, 5, 2, 4, 6};
        merge(array, 0, 3, 5);
        System.out.println(Arrays.toString(array));


    }

}
