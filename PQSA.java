import java.util.concurrent.ForkJoinPool;

/**
 * Author: Zhao Tong(zhao.tong@ucdconnect.ie), Chayanne Lavinia Mascarenhas (chayanne.mascarenhas@ucdconnect.ie)
 * PQSA Algorithm :
 * (MAIN THREAD) uses function sort(int datasetSize, int threadCount) to :
 *          - randomly generate an array of integers of size = datasetSize
 *          - create a new ForkJoinPool with parallelism = threadCount
 *          - start the timer
 *          - using the created ForkJoinPool, invoke RecursiveQuickSortTask (the recursive quick sort algorithm) exactly once
 *          - end the timer and output the time taken to stdout
 *          - verify the correctness of the sorting and output the result to stdout
 *          - return the sorted dataset
 */

public class PQSA {
    public static int maxThreads; // Maximum number of threads to be used for sorting

    public static int[] sort(int datasetSize, int threadCount) {

        //Randomly generate dataset of random integers
        int[] datasetRandomlyGenerated = HelpMethods.generateDataset(datasetSize);
        int[] datasetSorted = datasetRandomlyGenerated.clone();

        //Create new ForkJoinPool pool with specified number of CPU cores (threadCount)
        ForkJoinPool pool = new ForkJoinPool(threadCount);

        // Start timing
        long startTime = System.nanoTime();

        // Invoke initial RecursiveQuickSortTask from target pool
        pool.invoke(new RecursiveQuickSortTask(datasetSorted));

        // End timing
        long endTime = System.nanoTime();
        System.out.println("Thread count is " + threadCount + ", PQSA Sorting Time: " + ((endTime - startTime) / 1e9) + " seconds");

        // Verify Correctness
        if (HelpMethods.verifyCorrectness(datasetRandomlyGenerated, datasetSorted)) {
            System.out.println("Correctly sorting\n");
        } else {
            System.out.println("Incorrectly sorting\n");
        }

        // Return Sorted Dataset
        return datasetSorted;
    }
}
