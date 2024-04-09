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
        // -------------------------- Preparation ---------------------------------
        // get two subarrays
        int[] left_array = Arrays.copyOfRange(array, start, middle);
        int[] right_array = Arrays.copyOfRange(array, middle, end+1);

        // pointers to the beginning of subarrays
        int left_index = 0;                  // start of subarray 1
        int right_index = 0;                  // start of subarray 2

        // a pointer to the original array
        int origin_index = start;

        // --------------------------- Merge Arrays --------------------------------

        // 1. both left and right array are not be fully iterated
        while(left_index < left_array.length && right_index < right_array.length) {
            int left = left_array[left_index];
            int right = right_array[right_index];
            // if left < right, give left to original array. Update left index and origin index
            if (left < right) {
                array[origin_index] = left;
                ++left_index;
            }
            // else, give right to original array. Update right index and origin index
            else {
                array[origin_index] = right;
                ++right_index;
            }
            ++origin_index;
        }

        // 2. while left array is not fully iterated, give all of its rest elements to original array
        while(left_index < left_array.length) {
            array[origin_index] = left_array[left_index];
            ++left_index;
            ++origin_index;
        }
        // 3. while right array is not fully iterated, give all of its rest elements to original array
        while(right_index < right_array.length) {
            array[origin_index] = right_array[right_index];
            ++right_index;
            ++origin_index;
        }



    }

    public static void main(String[] args) {
        /* make sure int[] points to an object and Java passes object by reference
        int[] arr = {1, 2};
        merge(arr, 0, 1, 2);
        System.out.println(Arrays.toString(arr)); // print 2
        */

//        int[] array_1 = {1, 3, 5, 2, 4, 6};
//        merge(array_1, 0, 3, 5);
//        System.out.println(Arrays.toString(array_1));
//
//        int[] array_2 = {0};
//        merge(array_2, 0, 0, 0);
//        System.out.println(Arrays.toString(array_2));
        int[] array_1 = {1, 2, 3, 4, 5, 1, 2, 7, 8, 9};
        //        merge(array_1, 0, 3, 5);
        int length = array_1.length;
        int threadCount = 3; // The number of threads
        int interval = length / threadCount; // The number of integers in each subarray

        int j = 0;
        while (interval < length) {
            while (j + interval < length){
//                int end = j + 2 * interval > threadCount ? threadCount - 1: j + 2 * interval - 1;
                // warning: j + 2 * interval - 1 may > length
                int end = j + 2 * interval > length ? length - 1: j + 2 * interval - 1;
                NonRecursiveMergeSort.merge(array_1, j, j + interval, end);
                j += 2 * interval;
            }
            j = 0;
            interval *= 2;
        }

        System.out.println(Arrays.toString(array_1));


    }

}
