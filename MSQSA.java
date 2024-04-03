import java.util.Arrays;

/**
 * Author: Zhao Tong(zhao.tong@ucdconnect.ie)
 * This code is complete and the parallel process has been implemented.
 * But the odd thing here is that the running time for 8 threads is more than 2 and 4, but smaller than 1.
 * And I record the time used for both quicksort and mergesort,
 * turns out that time used in quicksort is what causes the problem
 * A running example is as follows:
 *       quicksort        mergesort          total time
 * 1:   0.313780791       0.004809084        0.318589875
 * 2:   0.159928834       0.007890916        0.16781975
 * 4:   0.13095375        0.008482667        0.139436417
 * 8:   0.202232833       0.009155125        0.211387958
 */

public class MSQSA {

    public static int[] sort(int[] dataset, int threadCount) {
        int[] array = dataset.clone();
        int length = array.length;
        int interval = (int) Math.ceil((double) length / threadCount);
        Thread[] threads = new Thread[threadCount];

        // Start timing
        long startTime = System.nanoTime();

        // Start threads to sort subarrays
        for (int i = 0; i < threadCount; i++) {
            int start = i * interval;
            int end = (i == threadCount - 1) ? length - 1 : (i + 1) * interval - 1;
            threads[i] = new Thread(() -> NonRecursiveQuickSort.sort(array, start, end));
            threads[i].start();
        }

        // Wait for all sorting threads to finish
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

//        long quicksortTime = System.nanoTime();
//        System.out.println("Quick sort Time: " + ((quicksortTime - startTime) / 1e9) + " seconds");


        // Now merge the sorted subarrays
        int j = 0;
        while (interval < length) {
            while (j + interval < length){
                int end = j + 2 * interval < length ?  j + 2 * interval - 1 : length - 1;
                NonRecursiveMergeSort.merge(array, j, j + interval, end);
                j += 2 * interval;
            }
            j = 0;
            interval *= 2;
        }

        // End timing
        long endTime = System.nanoTime();
//        System.out.println("Merge Time: " + ((endTime - quicksortTime) / 1e9) + " seconds");
        System.out.println("Thread count is " + threadCount + ",  MSQSA Sorting Time: " + ((endTime - startTime) / 1e9) + " seconds");

        if (HelpMethods.verifyCorrectness(dataset, array)) {
            System.out.println("Correctly sorting\n");
        } else {
            System.out.println("Incorrectly sorting\n");
        }
        return array;
    }
}
