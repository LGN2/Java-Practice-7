import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintQueueManager {
    public static void main(String[] args) {
        // Create the print queue and read its initial jobs.
        Scanner scanner = new Scanner(System.in);
        Queue<String> printJobs = new LinkedList<>();
        System.out.print("Enter number of print jobs: ");
        int jobCount = scanner.nextInt();
        scanner.nextLine();
        if (jobCount <= 0) {
            System.out.println("Invalid number of print jobs.");
            scanner.close();
            return;
        }
        for (int index = 0; index < jobCount; index++) {
            System.out.print("Enter print job " + (index + 1) + ": ");
            printJobs.offer(scanner.nextLine());
        }
        int choice;
        // Process print queue operations.
        do {
            System.out.println("\n1. Add Print Job\n2. Process Next Print Job\n3. View Next Print Job\n4. Search Print Job");
            System.out.println("5. Remove Print Job\n6. Display All Print Jobs\n7. Display Queue Statistics\n8. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter print job name: ");
                    printJobs.offer(scanner.nextLine());
                    System.out.println("Print job added successfully.");
                    break;
                case 2:
                    System.out.println(printJobs.isEmpty() ? "No print jobs in the queue." : "Processed print job: " + printJobs.poll());
                    break;
                case 3:
                    System.out.println(printJobs.isEmpty() ? "No print jobs in the queue." : "Next print job: " + printJobs.peek());
                    break;
                case 4:
                    System.out.print("Enter print job to search: ");
                    System.out.println(printJobs.contains(scanner.nextLine()) ? "Print job found." : "Print job not found.");
                    break;
                case 5:
                    System.out.print("Enter print job to remove: ");
                    System.out.println(printJobs.remove(scanner.nextLine()) ? "Print job removed successfully." : "Print job not found.");
                    break;
                case 6:
                    if (printJobs.isEmpty()) System.out.println("No print jobs in the queue.");
                    else for (String printJob : printJobs) System.out.println(printJob);
                    break;
                case 7:
                    System.out.println("Total number of print jobs: " + printJobs.size());
                    System.out.println("Next print job: " + (printJobs.isEmpty() ? "None" : printJobs.peek()));
                    System.out.println("Queue is empty: " + printJobs.isEmpty());
                    break;
                case 8: System.out.println("Program ended."); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 8);
        scanner.close();
    }
}
