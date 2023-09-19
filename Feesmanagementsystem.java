import java.util.ArrayList;
import java.util.Scanner;

class FeesManagementSystem {
    private String studentID;
    private String name;
    private double feesPaid;

    public Student(String studentID, String name) {
    this.studentID = studentID;
    this.name = name;
    this.feesPaid = 0;
}


    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void payFees(double amount) {
        feesPaid += amount;
    }

    public double getRemainingFees(double totalFees) {
        return totalFees - feesPaid;
    }
}

class FeesManagementSystem {
    private ArrayList<Student> students;

    public FeesManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentByID(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FeesManagementSystem system = new FeesManagementSystem();

        while (true) {
            System.out.println("\nFees Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Pay Fees");
            System.out.println("3. Check Remaining Fees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentID = scanner.next();
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    Student student = new Student(studentID, name);
                    system.addStudent(student);
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.next();
                    student = system.findStudentByID(studentID);
                    if (student != null) {
                        System.out.print("Enter fees amount to pay: ");
                        double amount = scanner.nextDouble();
                        student.payFees(amount);
                        System.out.println("Fees paid successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.next();
                    student = system.findStudentByID(studentID);
                    if (student != null) {
                        System.out.println("Remaining fees: $" + student.getRemainingFees(1000)); // Replace 1000 with the total fees for your scenario
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
