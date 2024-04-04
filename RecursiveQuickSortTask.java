import java.util.Random;
import java.util.concurrent.RecursiveAction;

/**Author : Chayanne Lavinia Mascarenhas (chayanne.mascarenhas@ucdconnect.ie)
 * Task structure to implement Recursive Quick Sort in Parallel
 */

public class RecursiveQuickSortTask extends RecursiveAction {

    final int[] arr;
    int low;
    int high;
    private final int THRESHOLD = 10;

    public RecursiveQuickSortTask(int[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
    }
    public RecursiveQuickSortTask(int[] arr){this(arr, 0, arr.length-1);}

    @Override
    protected void compute() {
        if(low < high) {
            int k = partition(arr, low, high);
            if (high - low < THRESHOLD) {
                quicksort(arr, low, k - 1);
                quicksort(arr, low, k + 1);
            }
            else {
                invokeAll(new RecursiveQuickSortTask(arr, low, k - 1),
                        new RecursiveQuickSortTask(arr, k + 1, high));
            }
        }
    }

    private static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int k = partition(arr, low, high);

            quicksort(arr, low, k - 1);
            quicksort(arr, k + 1, high);
        }
    }

        private static int partition(int[] arr, int low, int high) {
        Random rand = new Random();
        int k = rand.nextInt(low, high+1); //randomly select pivot
        swap(arr, k, high);                       //switch pivot with arr[high]
        k = arr[high];                            //set pivot to actual value

        //partition input around pivot value
        int i = low-1;
        //move values less than k to the left
        for(int j = low; j < high; j++){
            if(arr[j]<k){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
