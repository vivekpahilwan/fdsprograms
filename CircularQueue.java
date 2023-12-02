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
                i = (i + 1) % size;  //increase the pointer we have taken this modulo op so that whenever the pointer reaches end of queue so after incrementing the pointer it will perform the modulo operation and the remainder will be 0 so the pointer will point back to the 0th index position which is 0.
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //create the object of scnner class
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the capacity of the circular queue:");
        //take the size in capacity vaiable by scanning 
        int capacity = sc.nextInt();

        //create obj of circular queue by passing capacity in parameter
        CircularQueue cq = new CircularQueue(capacity);


        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            //scan and store the user input in choice variable
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the element to enqueue:");
                    int enqueueElement = sc.nextInt();
                    cq.enqueue(enqueueElement);
                    break;

                case 2:
                    cq.dequeue();
                    break;

                case 3:
                    cq.display();
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
