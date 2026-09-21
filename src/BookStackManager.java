import java.util.Scanner;
import java.util.Stack;

public class BookStackManager {
    public static void main(String[] args) {
        // Create the book stack and read its initial values.
        Scanner scanner = new Scanner(System.in);
        Stack<String> books = new Stack<>();
        System.out.print("Enter number of books: ");
        int bookCount = scanner.nextInt();
        scanner.nextLine();
        if (bookCount <= 0) {
            System.out.println("Invalid number of books.");
            scanner.close();
            return;
        }
        for (int index = 0; index < bookCount; index++) {
            System.out.print("Enter book title " + (index + 1) + ": ");
            books.push(scanner.nextLine());
        }
        int choice;
        // Process stack operations until Exit is selected.
        do {
            System.out.println("\n1. Add Book\n2. Remove Top Book\n3. View Top Book\n4. Search Book");
            System.out.println("5. Display All Books\n6. Display Stack Statistics\n7. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    books.push(scanner.nextLine());
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.println(books.isEmpty() ? "No books available." : "Removed book: " + books.pop());
                    break;
                case 3:
                    System.out.println(books.isEmpty() ? "No books available." : "Top book: " + books.peek());
                    break;
                case 4:
                    System.out.print("Enter book title to search: ");
                    int position = books.search(scanner.nextLine());
                    System.out.println(position == -1 ? "Book not found." : "Position from top: " + position);
                    break;
                case 5:
                    if (books.isEmpty()) System.out.println("No books available.");
                    else for (String book : books) System.out.println(book);
                    break;
                case 6:
                    System.out.println("Total number of books: " + books.size());
                    System.out.println("Top book: " + (books.isEmpty() ? "None" : books.peek()));
                    System.out.println("Stack is empty: " + books.isEmpty());
                    break;
                case 7: System.out.println("Program ended."); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 7);
        scanner.close();
    }
}
