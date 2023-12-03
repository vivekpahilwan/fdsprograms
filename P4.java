import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

class Employee {
    int id;
    String name;
    String position;
    double salary;

    Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    Employee() {
        this.id = 0;
        this.name = "0";
        this.position = "null";
        this.salary = 0;

    }

    public void display() {
        System.out.println("");
        System.out.println("ID        : " + id);
        System.out.println("Name      : " + name);
        System.out.println("Position  : " + position);
        System.out.println("Salary    : " + salary);
    }
}

class Company {
    Employee[] E;
    int capacity;
    int size = 0;

    Company(int capacity) {
        this.capacity = capacity;
        E = new Employee[capacity];
    }

    public void getData() {

        try {
            File file = new File("data.txt");
            Scanner rd = new Scanner(file);
            int id;
            String name;
            String position;
            double salary;
            while (rd.hasNextLine()) {
                id = Integer.parseInt(rd.nextLine());

                name = rd.nextLine();

                position = rd.nextLine();

                salary = Double.parseDouble(rd.nextLine());

                rd.nextLine();

                E[size] = new Employee(id, name, position, salary);
                size++;
            }
            rd.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found...");
        }
    }


    public void setData(){
        try {
            FileWriter writer = new FileWriter("data.txt");
            String data="";
            for(int i=0;i<size;i++){
               data+=""+E[i].id+"\n";
               data+=""+E[i].name+"\n";
               data+=""+E[i].position+"\n";
               data+=""+E[i].salary+"\n";
               data+="##############\n";
            }
            writer.write(data);
            writer.close();
            
        } catch (IOException e) {
            System.out.println("File Not Found....");
        }
    }

    public void add(Employee e) {
        E[size] = e;
        size++;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            E[i].display();
        }
    }

    public int search(int id) {
        int i = 0;
        while (i < size) {
            if (E[i].id == id) {
                System.out.println("Found : ");

                return (i);
            }
            i++;
        }
        System.out.println("Emplyee Not Found...");
        ;
        return -1;
    }

    public void modify() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Id to be Modified : ");
        int id = sc.nextInt();

        int index = this.search(id);
        if (index == -1) {
            return;
        }
        System.out.println("Enter what u want to modify (1.id 2.name 3.position 4.salary) : ");
        int mode = sc.nextInt();
        sc.nextLine();

        switch (mode) {
            case 1:
                System.out.print("Enter the Value : ");
                int nId = sc.nextInt();
                E[index].id = nId;
                break;
            case 2:
                System.out.print("Enter the Value : ");
                String nName = sc.nextLine();
                E[index].name = nName;

                break;
            case 3:
                System.out.print("Enter the Value : ");
                String nPosition = sc.nextLine();
                // sc.nextLine();
                E[index].position = nPosition;
                break;
            case 4:
                System.out.print("Enter the Value : ");
                double nSalary = sc.nextDouble();
                E[index].salary = nSalary;

                break;

            default:
                System.out.println("Try Again");
                break;
        }

    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Id to be Deleted : ");
        int id = sc.nextInt();

        int index = this.search(id);
        if (index == -1) {
            return;
        }

        for (int i = index + 1; i < size; i++) {
            E[i - 1] = E[i];
            if (i + 1 == size) {
                E[i] = null;
            }

        }
        this.size--;

    }

}

public class P4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Company com = new Company(100);
        boolean end = false;
        com.getData();
        while (!end) {
            System.out.println("");
            System.out.println("Enter the Command : \n1.add\n2.display\n3.search\n4.modify\n5.delete\n6.Exit\n");
            int inp = sc.nextInt();
            sc.nextLine();
            int id;

            switch (inp) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Employee Position: ");
                    String position = sc.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine(); // Consume the newline character

                    Employee e = new Employee(id, name, position, salary);
                    com.add(e);
                    break;
                case 2:
                    com.display();
                    break;
                case 3:
                    System.out.print("Enter Employee ID to Search: ");
                    id = sc.nextInt();

                    int index = com.search(id);
                    if (index != -1)
                        com.E[index].display();
                    break;

                case 4:
                    com.modify();
                    break;
                case 5:
                    com.delete();
                    break;

                case 6:
                    end = true;
                    com.setData();
                    break;
                default:
                    System.out.println("Wrong Input Try Again......");
                    break;
            }
        }
    }
}