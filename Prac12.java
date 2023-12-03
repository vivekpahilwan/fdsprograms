/**
 * Prac12 implement a priority Queue for a list of patients using linked list.
 */
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prac12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating a Priority Queue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Print elements");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the element to enqueue:");
                    int enqueueElement = sc.nextInt();
                    priorityQueue.offer(enqueueElement);
                    System.out.println(enqueueElement + " enqueued successfully.");
                    break;

                case 2:
                    if (!priorityQueue.isEmpty()) {
                        int dequeuedElement = priorityQueue.poll();
                        System.out.println(dequeuedElement + " dequeued successfully.");
                    } else {
                        System.out.println("Queue is empty. Cannot dequeue.");
                    }
                    break;

                case 3:
                    System.out.println("Elements in the priority queue: " + priorityQueue);
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
