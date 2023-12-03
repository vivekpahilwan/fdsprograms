import java.util.Scanner;

public class P5 {

    static void print(String[] list) {
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

    static String[] getStrings() {

        System.out.print("Enter the length of the List : ");
        size = sc.nextInt();
        sc.nextLine();
        String[] list = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the string no." + (i + 1) + " : ");
            list[i] = sc.nextLine();
        }
        return list;

    }

    static String[] asendingInsertion(String[] list) {
        for (int i = 1; i < size; i++) {
            String key = list[i];
            int j = i - 1;
            int it = 0;
            while (j >= 0 && list[j].compareTo(key) > 0) {
                System.out.print("Iteration " + (it) + " : ");
                print(list);
                list[j + 1] = list[j];
                j--;
                it++;
            }
            list[j + 1] = key;

        }
        return list;
    }

    static String[] insertion(String[] list) {
        for (int i = 1; i < size; i++) {
            String key = list[i];
            int j = i - 1;

            while (j >= 0 && list[j].compareTo(key) > 0) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;

        }
        return list;
    }

    static String[] decendingSelection(String[] list) {
        String temp;
        int biggest;
        for (int i = 0; i < size - 1; i++) {
            biggest = i;
            for (int j = i + 1; j < size; j++) {
                System.out.print("Iteration " + (i + j) + " : ");
                print(list);
                if (list[biggest].compareTo(list[j]) < 0) {
                    biggest = j;
                }

            }
            temp = list[biggest];
            list[biggest] = list[i];
            list[i] = temp;

        }
        return list;
    }

    static int binary(String[] list, String str) {
        list = insertion(list);
        int left = 0;
        int right = size - 1;
        int mid;

        while (left <= right) {
            System.out.print("Iteration : ");
            print(list);
            mid = (left + right) / 2;
            if (list[mid].equals(str)) {
                return mid;
            } else if (list[mid].compareTo(str) > 0) {
                right = mid - 1;
            } else if (list[mid].compareTo(str) < 0) {
                left = mid + 1;
            }
        }

        return -1;

    }

    static int binaryRecur(String[] list, String str, int left, int right) {
        int mid = (left + right) / 2;
        System.out.print("Iteration : ");
        print(list);
        if (right < left) {
            return -1;
        }
        if (str.equals(list[mid])) {
            return mid;
        }

        else if (list[mid].compareTo(str) > 0) {
            return binaryRecur(list, str, left, mid - 1);
        } else {
            return binaryRecur(list, str, mid + 1, right);
        }

    }

    static Scanner sc = new Scanner(System.in);
    static int size;

    public static void main(String[] args) {
        String list[] = getStrings();


        boolean end = false;

        while(!end){
            System.out.println("Enter the Operation \n1.Insertion Sort \n2.Selection Sort \n3.Binary Search \n4.Binary Search Recursion\n5.Exit");
            int mode = sc.nextInt();
            sc.nextLine();
            String str;

            switch (mode) {
                case 1:
                    
                    print(asendingInsertion(list));
                    break;
                case 2:
                   
                    print(decendingSelection(list));
                    break;
                case 3:
                    System.out.print("Enter the String to be Searched : ");
                    str = sc.nextLine();
                    System.out.println("Index for "+str+" : "+binary(list,str));
                    
                    break;
                case 4:
                    System.out.print("Enter the String to be Searched : ");
                    str = sc.nextLine();
                    System.out.println("Index for "+str+" : "+binaryRecur(insertion(list),str,0,size-1));
                    
                    break;
                case 5:
                    end = true;
                    break;
            
                default:
                    break;
            }

        }




    }
}