package TestJP2;

import java.io.*;
import java.util.*;


public class Student {
    private String id;
    private String name;
    private String address;

    private String phone;

    public Student( String id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("<-----Welcome to the Student management program----->");
            System.out.println("1. Add student");
            System.out.println("2. Display students");
            System.out.println("3. Save students");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    add(students);
                    break;
                case 2:
                    display(students);
                    break;
                case 3:
                    save(students);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void add(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID: ");
        String id = sc.nextLine();
        System.out.println("Enter name: ");
        String name = sc.nextLine();

        System.out.println("Enter address: ");
        String address = sc.nextLine();
        System.out.println("Enter phone: ");
        String phone = sc.nextLine();

        students.add(new Student(id, name, address, phone));
        System.out.println("Student added successfully!");
    }

    public static void display(ArrayList<Student> students) {
        for (Student st : students) {
            System.out.println("<======List Student======>");
            System.out.println("ID: " + st.getId());
            System.out.println("Name: " + st.getName());
            System.out.println("Address: " + st.getAddress());
            System.out.println("Phone: " + st.getPhone());
            System.out.println("--------------------");
        }
    }

    public static void save(ArrayList<Student> students) {
        try {
            BufferedWriter bwriter = new BufferedWriter(new FileWriter("src/TestJP2/students.txt"));
            for (Student student : students) {
                bwriter.write(student.getId() + ","  + student.getName() + "," + student.getAddress() + "," + student.getPhone() +  "\n");
            }
            bwriter.close();
            System.out.println("Students saved successfully!");
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }


}

