/*
Author: ZHAO TONG
*/

import java.util.Random;

public class Main {
    private static int[] dataset1, dataset2, dataset3;
    public static void main(String[] args) {

        // Call MSQSA with the thread count as input
        // and an ArrayList containing the running time for all 3 datasets
        System.out.println("--------------------Dataset size: 1000000--------------------");
        MSQSA.sort(1000000,1);
        MSQSA.sort(1000000,2);
        MSQSA.sort(1000000,4);
        MSQSA.sort(1000000,8);

        // and an ArrayList containing the running time for all 3 datasets
        System.out.println("--------------------Dataset size: 2000000--------------------");
        MSQSA.sort(2000000,1);
        MSQSA.sort(2000000,2);
        MSQSA.sort(2000000,4);
        MSQSA.sort(2000000,8);

        // and an ArrayList containing the running time for all 3 datasets
        System.out.println("--------------------Dataset size: 5000000--------------------");
        MSQSA.sort(5000000,1);
        MSQSA.sort(5000000,2);
        MSQSA.sort(5000000,4);
        MSQSA.sort(5000000,8);
    }
}
