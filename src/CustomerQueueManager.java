import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CustomerQueueManager {
    public static void main(String[] args) {
        // Create the customer queue and read its initial values.
        Scanner scanner = new Scanner(System.in);
        Queue<String> customers = new LinkedList<>();
        System.out.print("Enter number of customers: ");
        int customerCount = scanner.nextInt();
        scanner.nextLine();
        if (customerCount <= 0) {
            System.out.println("Invalid number of customers.");
            scanner.close();
            return;
        }
        for (int index = 0; index < customerCount; index++) {
            System.out.print("Enter customer name " + (index + 1) + ": ");
            customers.offer(scanner.nextLine());
        }
        int choice;
        // Process customer queue operations.
        do {
            System.out.println("\n1. Add Customer\n2. Serve Customer\n3. View Next Customer\n4. Search Customer");
            System.out.println("5. Display All Customers\n6. Display Queue Statistics\n7. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    customers.offer(scanner.nextLine());
                    System.out.println("Customer added successfully.");
                    break;
                case 2:
                    System.out.println(customers.isEmpty() ? "No customers in the queue." : "Served customer: " + customers.poll());
                    break;
                case 3:
                    System.out.println(customers.isEmpty() ? "No customers in the queue." : "Next customer: " + customers.peek());
                    break;
                case 4:
                    System.out.print("Enter customer name to search: ");
                    System.out.println(customers.contains(scanner.nextLine()) ? "Customer found." : "Customer not found.");
                    break;
                case 5:
                    if (customers.isEmpty()) System.out.println("No customers in the queue.");
                    else for (String customer : customers) System.out.println(customer);
                    break;
                case 6:
                    String lastCustomer = "None";
                    for (String customer : customers) lastCustomer = customer;
                    System.out.println("Total number of customers: " + customers.size());
                    System.out.println("First customer: " + (customers.isEmpty() ? "None" : customers.peek()));
                    System.out.println("Last customer: " + lastCustomer);
                    System.out.println("Queue is empty: " + customers.isEmpty());
                    break;
                case 7: System.out.println("Program ended."); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 7);
        scanner.close();
    }
}
