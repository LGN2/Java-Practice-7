import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StudentRegistrationManager {
    public static void main(String[] args) {
        // Create the waiting queue and completed-registration stack.
        Scanner scanner = new Scanner(System.in);
        Queue<String> waitingStudents = new LinkedList<>();
        Stack<String> registeredStudents = new Stack<>();
        System.out.print("Enter number of students waiting for registration: ");
        int studentCount = scanner.nextInt();
        scanner.nextLine();
        if (studentCount <= 0) {
            System.out.println("Invalid number of students.");
            scanner.close();
            return;
        }
        for (int index = 0; index < studentCount; index++) {
            System.out.print("Enter student name " + (index + 1) + ": ");
            waitingStudents.add(scanner.nextLine());
        }
        int choice;
        // Process registration operations.
        do {
            System.out.println("\n1. Add Student to Queue\n2. Process Student Registration\n3. View Next Student");
            System.out.println("4. Undo Last Registration\n5. Search Student\n6. Display Waiting Students");
            System.out.println("7. Display Registered Students\n8. Display Statistics\n9. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    waitingStudents.add(scanner.nextLine());
                    System.out.println("Student added to registration queue successfully.");
                    break;
                case 2:
                    if (waitingStudents.isEmpty()) System.out.println("No students waiting for registration.");
                    else {
                        String student = waitingStudents.remove();
                        registeredStudents.push(student);
                        System.out.println("Student registration completed. Student: " + student);
                    }
                    break;
                case 3:
                    System.out.println(waitingStudents.isEmpty() ? "No students in the queue." : "Next student: " + waitingStudents.element());
                    break;
                case 4:
                    System.out.println(registeredStudents.isEmpty() ? "No registrations to undo." : "Registration undone for: " + registeredStudents.pop());
                    break;
                case 5:
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine();
                    if (waitingStudents.contains(searchName)) System.out.println("Student is waiting for registration.");
                    else if (registeredStudents.search(searchName) != -1) System.out.println("Student is already registered.");
                    else System.out.println("Student not found.");
                    break;
                case 6:
                    if (waitingStudents.isEmpty()) System.out.println("No waiting students.");
                    else for (String student : waitingStudents) System.out.println(student);
                    break;
                case 7:
                    if (registeredStudents.isEmpty()) System.out.println("No registered students.");
                    else for (String student : registeredStudents) System.out.println(student);
                    break;
                case 8:
                    System.out.println("Total waiting students: " + waitingStudents.size());
                    System.out.println("Total registered students: " + registeredStudents.size());
                    System.out.println("Next student waiting: " + (waitingStudents.isEmpty() ? "None" : waitingStudents.element()));
                    System.out.println("Last registered student: " + (registeredStudents.isEmpty() ? "None" : registeredStudents.peek()));
                    System.out.println("Queue is empty: " + waitingStudents.isEmpty());
                    System.out.println("Stack is empty: " + registeredStudents.isEmpty());
                    break;
                case 9: System.out.println("Program ended."); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 9);
        scanner.close();
    }
}
