import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class HospitalPatientManager {
    public static void main(String[] args) {
        // Create the waiting queue and completed-treatment stack.
        Scanner scanner = new Scanner(System.in);
        Queue<String> waitingPatients = new LinkedList<>();
        Stack<String> treatedPatients = new Stack<>();
        System.out.print("Enter number of patients waiting: ");
        int patientCount = scanner.nextInt();
        scanner.nextLine();
        if (patientCount <= 0) {
            System.out.println("Invalid number of patients.");
            scanner.close();
            return;
        }
        for (int index = 0; index < patientCount; index++) {
            System.out.print("Enter patient name " + (index + 1) + ": ");
            waitingPatients.offer(scanner.nextLine());
        }
        int choice;
        // Process hospital patient operations.
        do {
            System.out.println("\n1. Add Patient\n2. Treat Patient\n3. View Next Patient\n4. Undo Last Treatment");
            System.out.println("5. Search Patient\n6. Display Waiting Patients\n7. Display Treated Patients");
            System.out.println("8. Display Hospital Statistics\n9. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    waitingPatients.offer(scanner.nextLine());
                    System.out.println("Patient added successfully.");
                    break;
                case 2:
                    if (waitingPatients.isEmpty()) System.out.println("No patients waiting for treatment.");
                    else {
                        String patient = waitingPatients.poll();
                        treatedPatients.push(patient);
                        System.out.println("Patient treatment completed successfully. Patient: " + patient);
                    }
                    break;
                case 3:
                    System.out.println(waitingPatients.isEmpty() ? "No patients available." : "Next patient: " + waitingPatients.peek());
                    break;
                case 4:
                    System.out.println(treatedPatients.isEmpty() ? "No completed treatments available." : "Treatment undone for: " + treatedPatients.pop());
                    break;
                case 5:
                    System.out.print("Enter patient name to search: ");
                    String searchName = scanner.nextLine();
                    if (waitingPatients.contains(searchName)) System.out.println("Patient is waiting for treatment.");
                    else if (treatedPatients.search(searchName) != -1) System.out.println("Patient treatment completed.");
                    else System.out.println("Patient not found.");
                    break;
                case 6:
                    if (waitingPatients.isEmpty()) System.out.println("No waiting patients.");
                    else for (String patient : waitingPatients) System.out.println(patient);
                    break;
                case 7:
                    if (treatedPatients.isEmpty()) System.out.println("No treated patients.");
                    else for (String patient : treatedPatients) System.out.println(patient);
                    break;
                case 8:
                    System.out.println("Total waiting patients: " + waitingPatients.size());
                    System.out.println("Total treated patients: " + treatedPatients.size());
                    System.out.println("Next patient waiting: " + (waitingPatients.isEmpty() ? "None" : waitingPatients.peek()));
                    System.out.println("Last treated patient: " + (treatedPatients.isEmpty() ? "None" : treatedPatients.peek()));
                    System.out.println("Queue is empty: " + waitingPatients.isEmpty());
                    System.out.println("Stack is empty: " + treatedPatients.isEmpty());
                    break;
                case 9: System.out.println("Program ended."); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 9);
        scanner.close();
    }
}
