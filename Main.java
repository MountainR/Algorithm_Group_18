/*
Author: ZHAO TONG
*/

import java.util.Random;

public class Main {
    private static int[] dataset1, dataset2, dataset3;
    public static void main(String[] args) {

        // Call MSQSA and POSA with the thread count as input
        // and an ArrayList containing the running time for all 3 datasets
        System.out.println("--------------------Dataset size: 1000000--------------------");
        MSQSA.sort(1000000,1);
        MSQSA.sort(1000000,2);
        MSQSA.sort(1000000,4);
        MSQSA.sort(1000000,8);
    }
}
