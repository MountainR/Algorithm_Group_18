/*
Author: ZHAO TONG
*/

import java.util.Random;

public class Main {
    private static int[] dataset1, dataset2, dataset3;
    public static void main(String[] args) {
//        dataset1 = HelpMethods.generateDataset(1000000);
//        dataset2 = HelpMethods.generateDataset(2000000);
//        dataset3 = HelpMethods.generateDataset(5000000);

        // Call MSQSA and POSA with the thread count as input 
        // and an ArrayList containing the running time for all 3 datasets
        MSQSA.sort(1);
        MSQSA.sort(2);
        MSQSA.sort(4);
        MSQSA.sort(8);
    }
}
