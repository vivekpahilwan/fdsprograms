/*explanation
1.Choose a Pivot: Select an element from the array to serve as the pivot.
Common choices include the first element, the last element, or a random element.

2.Partitioning: Rearrange the elements in the array so that all elements smaller than the pivot are moved to its left, and all elements greater than the pivot are moved to its right. The pivot is now in its final sorted position.

3.Recursion: Apply the QuickSort algorithm recursively to the sub-arrays on the left and right of the pivot. 
This process is repeated until the entire array is sorted.

4.Base Case: The recursion stops when the sub-arrays have only one element or are empty (base case).*/

public class quicksort {

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high]; // took the last element as pivot

        int i = low - 1; // tracks elements smaller than pivot

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++; // makes place for pivot
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i; // pivot index
    }

    public static void quicksort(int arr[], int low, int high) {
        if (low < high) {
            int pidx = partition(arr, low, high);

            quicksort(arr, low, pidx - 1); // for elements which are smaller than pivot
            quicksort(arr, pidx + 1, high); // for elements which are greater than pivot
        }
    }

    public static void main(String args[]) {
        int[] arr = { 6, 3, 9, 5, 2, 8 };
        int n = arr.length;

        quicksort(arr, 0, n - 1); // calls quick sort function

        // print sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}


