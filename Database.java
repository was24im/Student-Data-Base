import java.util.HashMap;
import java.util.Scanner;

class student {
    public String name;
    public int rollNo;
    public int age;
    public int marks;


    public student (String name, int rollNo, int age, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.marks = marks;
    }
    public int display () {
        return rollNo;
    }
    public void viewStudent () {
        System.out.println("Name: " +name);
        System.out.println("Roll No: " +rollNo);
        System.out.println("Age: " +age);
        System.out.println("Marks: " +marks);
    }
}

public class Database {

    public static void main(String [] args) {

        HashMap<Integer,student>database = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add student");
            System.out.println("2. view student");
            System.out.println("3. search student");
            System.out.println("4. Calculate average marks");
            System.out.println("5. exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: System.out.print("Enter your name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Enter your Roll No: ");
                        int rollNo = sc.nextInt();
                        System.out.print("Enter your Age: ");
                        int age = sc.nextInt();
                        System.out.print("Enter your Marks: ");
                        int marks = sc.nextInt();
                        student std = new student (name, rollNo, age, marks);
                        database.put(rollNo, std);
                        System.out.println("Student added successfully");
                        break;
                case 2: System.out.println("List of students: ");
                        for (student i : database.values()) {
                            i.viewStudent();
                        }
                        break;
                case 3: System.out.print("Enter your Roll No: ");   
                        int roll = sc.nextInt();
                        student data = database.get(roll);
                        if (data != null) {
                            data.viewStudent();
                        }
                        else {
                            System.out.println("Student not found");
                        }
                        System.out.println("------------------------------------");
                        break;
                case 4: int totalStudents = database.size();
                        int totalMarks = 0;
                        for (student j : database.values()) {
                            totalMarks = totalMarks + j.marks;
                        }
                        double average = (double) totalMarks / totalStudents;
                        System.out.println("Average Marks: " +average);
                        break;
                case 5: System.exit(0);  
                        break;
                default : System.out.println("Invalid Choice");
                    
            }
        }
    }
}