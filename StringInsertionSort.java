import java.util.Scanner;

public class StringInsertionSort {

    public static void insertionSort(String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            String key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of strings: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        String[] stringArray = new String[size];

        System.out.println("Enter the strings:");

        for (int i = 0; i < size; ++i) {
            System.out.print("String " + (i + 1) + ": ");
            stringArray[i] = scanner.nextLine();
        }

        scanner.close();

        System.out.println("\nOriginal array:");
        for (String s : stringArray) {
            System.out.print(s + " ");
        }

        insertionSort(stringArray);

        System.out.println("\nArray after Insertion Sort:");
        for (String s : stringArray) {
            System.out.print(s + " ");
        }
    }
}
