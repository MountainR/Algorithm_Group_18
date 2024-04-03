/**
 * Author: Zhao Tong(zhao.tong@ucdconnect.ie)
 * This code is incomplete 
 * Two parts for creating threads and waiting all threads to finish the current work need to be added
 */

public class PQSA {
    public static int maxThreads; // Maximum number of threads to be used for sorting

    public static int[] sort(int[] dataset, int threadCount) {
        int[] array = dataset.clone();

        //--------------------------------------------------------------------------------
        // Code segment of creating threads
        //--------------------------------------------------------------------------------

        // Start timing
        long startTime = System.nanoTime();

        // Call the recursive quicksort function which will manage threads
        RecursiveQuickSort.quicksort(array, 0, array.length - 1);

        //--------------------------------------------------------------------------------
        // Code segment of parallel process needs to be added:
        // this part is for waiting all threads to finish their current work.
        //--------------------------------------------------------------------------------

        // End timing
        long endTime = System.nanoTime();
        System.out.println("Thread count is " + threadCount + ", PQSA Sorting Time: " + ((endTime - startTime) / 1e9) + " seconds");

        if (HelpMethods.verifyCorrectness(dataset, array)) {
            System.out.println("Correctly sorting\n");
        } else {
            System.out.println("Incorrectly sorting\n");
        }
        return array;
    }
}
