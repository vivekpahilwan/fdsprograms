import java.util.Scanner;

public class P6 {

    public static void print(int[] list) {
        System.out.print("[ ");
        for (int i = 0; i < list.length; i++) {
            if (i == list.length - 1) {
                System.out.print(list[i] + " ");
                break;
            }
            System.out.print(list[i] + " ");
        }
        System.out.print("]\n");
    }

    public static int[] getList() {

        System.out.print("Enter the length of the List : ");
        size = sc.nextInt();
        sc.nextLine();
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the number at " + (i + 1) + " : ");
            list[i] = sc.nextInt();
        }
        return list;

    }

    public static int partition(int[] list, int start, int end) {

        int pivot = list[end];
        int i = start - 1;
        int j = start;
        while (j < end) {
            if (list[j] < pivot) {
                i++;
                int temp = list[j];
                list[j] = list[i];
                list[i] = temp;
            }
            j++;
        }
        i++;
        list[end] = list[i];
        list[i] = pivot;
        System.out.print("Iterations : ");
        print(list);
        return i;

    }

    public static void quickSort(int[] list, int start, int end) {
        if (start < end) {
            int pivot = partition(list, start, end);

            quickSort(list, start, pivot - 1);
            quickSort(list, pivot + 1, end);
        }

    }

    public static void mergeSort(int[] list, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(list, start, mid);
        mergeSort(list, mid + 1, end);
        merge(list, start, mid, end);

    }

    static void merge(int list[], int start, int mid, int end) {
        int newList[] = new int[end - start + 1];
        int idx = start;
        int idy = mid + 1;
        int i = 0;
        while (idx <= mid && idy <= end) {
            if (list[idx] <= list[idy]) {
                newList[i] = list[idx];
                idx++;
            } else {
                newList[i] = list[idy];
                idy++;
            }
            i++;
        }
        while (idx <= mid) {
            newList[i] = list[idx];
            idx++;
            i++;
        }
        while (idy <= end) {
            newList[i] = list[idy];
            idy++;
            i++;
        }
        for (i = 0; i < newList.length; i++) {
            list[start + i] = newList[i];
        }
        System.out.print("Iterations : ");
        print(list);

    }

    static Scanner sc = new Scanner(System.in);
    static int size;

    public static void main(String[] args) {
        int[] list = getList();
        int[] mList = list;
        int[] qList = list;

      
 
        boolean end = false;

        while (!end) {
            System.out.println("Enter the Operation \n1.Quick Sort \n2.Merge Sort\n3.Exit");
            int mode = sc.nextInt();
            sc.nextLine();

            switch (mode) {
                case 1:

                    quickSort(qList, 0, size - 1);
                    System.out.print("Sorted List : ");
                    print(qList);

                    break;
                case 2:

                    mergeSort(mList, 0, size - 1);
                    System.out.print("Sorted List : ");
                    print(mList);

                    break;

                case 3:
                    end = true;
                    break;

                default:
                    break;
            }

        }
    }
}