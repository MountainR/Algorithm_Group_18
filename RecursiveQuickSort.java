import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Description : Recursive Quick Sort for PQSA (EXAMPLE WITHOUT PARALLEL, SEE RECURSIVE QUICK SORT TASK)
 * -> base recursive quick sort (complete)
 */
public class RecursiveQuickSort {

    private static Random rand = new Random();

    //wrapper method (testing)
    public static void quicksort(int[] array) {
        int low = 0;
        int high = array.length - 1;
        quicksort(array, low, high);
    }

    //recursive, parallel part (calls itself recursively -> split left right sub-arrays into parallel tasks)
    private static void quicksort(int[] array, int low, int high) {

        if(low < high){
            int k = partition(array, low, high);

            /*need to run as parallel tasks (see java concurrent framework)*/
            quicksort(array, low, k-1);
            quicksort(array, k+1, high);
        }
    }

    //partition part (non-recursive, non-parallel)
    private static int partition(int[] array, int low, int high) {
        int k = rand.nextInt(low, high+1); //randomly select pivot
        swap(array, k, high);                     //switch pivot with arr[high]
        k = array[high];                          //set pivot to actual value

        //partition input around pivot value
        int i = low-1;
        //move values less than k to the left
        for(int j = low; j < high; j++){
            if(array[j]<k){
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, high);
        return i+1;
    }
    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = IntStream.range(1,9).map((x)-> rand.nextInt(1,100)+x).toArray();
        quicksort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[]{9,7,8,6,5,3,4,0,1,2};
        quicksort(arr1);
        System.out.println(Arrays.toString(arr1));


    }

}
