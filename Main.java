/*
Author: ZHAO TONG
*/

import java.util.Random;

public class Main {
    private static int[] dataset1, dataset2, dataset3;
    public static void main(String[] args) {
        dataset1 = HelpMethods.generateDataset(1000000);
        dataset2 = HelpMethods.generateDataset(2000000);
        dataset3 = HelpMethods.generateDataset(5000000);

        // Call MSQSA and POSA with the all three datasets as input.

        MSQSA.sort(dataset1,1);
        MSQSA.sort(dataset1,2);
        MSQSA.sort(dataset1,4);
        MSQSA.sort(dataset1,8);


//        HelpMethods.printDataset(dataset1);
//        HelpMethods.printDataset(PQSA.sort(dataset1,1));
//        HelpMethods.printDataset(PQSA.sort(dataset1,2));
//        HelpMethods.printDataset(PQSA.sort(dataset1,4));
    }
}
