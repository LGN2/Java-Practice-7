import java.util.Scanner;
import java.util.Stack;

public class UndoActionManager {
    public static void main(String[] args) {
        // Create the action stack and read its initial values.
        Scanner scanner = new Scanner(System.in);
        Stack<String> actions = new Stack<>();
        System.out.print("Enter number of actions: ");
        int actionCount = scanner.nextInt();
        scanner.nextLine();
        if (actionCount <= 0) {
            System.out.println("Invalid number of actions.");
            scanner.close();
            return;
        }
        for (int index = 0; index < actionCount; index++) {
            System.out.print("Enter action " + (index + 1) + ": ");
            actions.push(scanner.nextLine());
        }
        int choice;
        // Process action operations until Exit is selected.
        do {
            System.out.println("\n1. Add Action\n2. Undo Last Action\n3. View Last Action\n4. Search Action");
            System.out.println("5. Display All Actions\n6. Display Action Statistics\n7. Clear All Actions\n8. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter action: ");
                    actions.push(scanner.nextLine());
                    System.out.println("Action added successfully.");
                    break;
                case 2:
                    System.out.println(actions.isEmpty() ? "No actions to undo." : "Undone action: " + actions.pop());
                    break;
                case 3:
                    System.out.println(actions.isEmpty() ? "No actions available." : "Last action: " + actions.peek());
                    break;
                case 4:
                    System.out.print("Enter action to search: ");
                    int position = actions.search(scanner.nextLine());
                    System.out.println(position == -1 ? "Action not found." : "Position from top: " + position);
                    break;
                case 5:
                    if (actions.isEmpty()) System.out.println("No actions available.");
                    else for (String action : actions) System.out.println(action);
                    break;
                case 6:
                    System.out.println("Total number of actions: " + actions.size());
                    System.out.println("Most recent action: " + (actions.isEmpty() ? "None" : actions.peek()));
                    System.out.println("Stack is empty: " + actions.isEmpty());
                    break;
                case 7:
                    actions.clear();
                    System.out.println("All actions have been cleared.");
                    break;
                case 8: System.out.println("Program ended."); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 8);
        scanner.close();
    }
}
