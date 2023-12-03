import java.util.Scanner;

class InventoryItem {
    int itemCode;
    double itemPrice;

    public InventoryItem(int itemCode, double itemPrice) {
        this.itemCode = itemCode;
        this.itemPrice = itemPrice;
    }
}

public class InventorySystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryItem[] inventory = new InventoryItem[100];
        int size = 0;

        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addRecord(inventory, scanner, size++);
                    break;
                case 2:
                    displayDatabase(inventory, size);
                    break;
                case 3:
                    searchRecord(inventory, size, scanner.nextInt());
                    break;
                case 4:
                    deleteRecord(inventory, size, scanner.nextInt());
                    size--;
                    break;
                case 5:
                    sortRecordsByPrice(inventory, size);
                    System.out.println("Records sorted successfully.");
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nInventory System Menu");
        System.out.println("1. Add Record");
        System.out.println("2. Display Database");
        System.out.println("3. Search Record");
        System.out.println("4. Delete Record");
        System.out.println("5. Sort Records by Price");
        System.out.println("0. Exit");
    }

    private static void addRecord(InventoryItem[] inventory, Scanner scanner, int size) {
        System.out.print("Enter item code: ");
        int itemCode = scanner.nextInt();
        System.out.print("Enter item price: ");
        double itemPrice = scanner.nextDouble();

        inventory[size] = new InventoryItem(itemCode, itemPrice);
        System.out.println("Record added successfully.");
    }

    private static void displayDatabase(InventoryItem[] inventory, int size) {
        System.out.println("\nInventory Database:");
        for (int i = 0; i < size; i++) {
            System.out.println("Item Code: " + inventory[i].itemCode +
                    ", Item Price: $" + inventory[i].itemPrice);
        }
    }

    private static void searchRecord(InventoryItem[] inventory, int size, int searchCode) {
        for (int i = 0; i < size; i++) {
            if (inventory[i].itemCode == searchCode) {
                System.out.println("Record found: " + inventory[i]);
                return;
            }
        }
        System.out.println("Record not found for item code " + searchCode);
    }

    private static void deleteRecord(InventoryItem[] inventory, int size, int deleteCode) {
        for (int i = 0; i < size; i++) {
            if (inventory[i].itemCode == deleteCode) {
                System.arraycopy(inventory, i + 1, inventory, i, size - i - 1);
                System.out.println("Record deleted successfully.");
                return;
            }
        }
        System.out.println("Record not found for item code " + deleteCode);
    }

    private static void sortRecordsByPrice(InventoryItem[] inventory, int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (inventory[j].itemPrice > inventory[j + 1].itemPrice) {
                    InventoryItem temp = inventory[j];
                    inventory[j] = inventory[j + 1];
                    inventory[j + 1] = temp;
                }
            }
        }
    }
}
