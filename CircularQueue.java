import java.util.Scanner;

public class CircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;


    //  constructor to create a CQ by passing the size as the parameter
    public CircularQueue(int capacity) {
        size = capacity + 1; // One extra space to distinguish between full and empty states
        queue = new int[size];
        front = rear = 0;
    }

    //if front = rear then returns true
    public boolean isEmpty() {
        return front == rear;
    }

    //if (rear+1)%size = front then returns true
    // modulo operator checks if the queue wraps around the array
    public boolean isFull() {
        return (rear + 1) % size == front;
    }


    //ENQUEUE

    public void enqueue(int element) {
        //if 
        //queue is full then print Queue Full
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
        } 
        //else 
        //add the element at rear which is queue[rear]
        else {
            queue[rear] = element;
            rear = (rear + 1) % size;   //update the rear by rear = (rear+1)%size
            System.out.println(element + " enqueued successfully.");
        }
    }

    //DEQUEUE
   
    public void dequeue() {
        //if 
        //the queue is empty then print queue is empty 
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
        } 
        //else 
        else {
            int dequeuedElement = queue[front]; // take the first element of queue and put it into a varible
            front = (front + 1) % size;         //increase the pointer of the front 
            System.out.println(dequeuedElement + " dequeued successfully.");//print thr dequeued element
        }
    }

    public void display() {
        //if queue is empty then print the queue is empty 
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } 
        
        else {
            System.out.print("Elements in the circular queue: ");
            //iterate through the elements till the front is not equal to rear
            int i = front;
            while (i != rear) {
                System.out.print(queue[i] + " ");
                i = (i + 1) % size;  //increase the pointer
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the capacity of the circular queue:");
        int capacity = scanner.nextInt();

        CircularQueue circularQueue = new CircularQueue(capacity);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the element to enqueue:");
                    int enqueueElement = scanner.nextInt();
                    circularQueue.enqueue(enqueueElement);
                    break;

                case 2:
                    circularQueue.dequeue();
                    break;

                case 3:
                    circularQueue.display();
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
