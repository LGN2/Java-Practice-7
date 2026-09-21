import java.util.Scanner;
import java.util.Stack;

public class NumberStackAnalyzer {
    public static void main(String[] args) {
        // Create the number stack and read its initial values.
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> numbers = new Stack<>();
        System.out.print("Enter number of values: ");
        int valueCount = scanner.nextInt();
        if (valueCount <= 0) {
            System.out.println("Invalid number of values.");
            scanner.close();
            return;
        }
        for (int index = 0; index < valueCount; index++) {
            System.out.print("Enter value " + (index + 1) + ": ");
            numbers.push(scanner.nextInt());
        }
        int choice;
        // Process number and analysis operations.
        do {
            System.out.println("\n1. Add Number\n2. Remove Top Number\n3. View Top Number");
            System.out.println("4. Display All Numbers\n5. Analyze Numbers\n6. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    numbers.push(scanner.nextInt());
                    System.out.println("Number added successfully.");
                    break;
                case 2:
                    System.out.println(numbers.isEmpty() ? "Stack is empty." : "Removed number: " + numbers.pop());
                    break;
                case 3:
                    System.out.println(numbers.isEmpty() ? "Stack is empty." : "Top number: " + numbers.peek());
                    break;
                case 4:
                    if (numbers.isEmpty()) System.out.println("Stack is empty.");
                    else for (int number : numbers) System.out.println(number);
                    break;
                case 5:
                    if (numbers.isEmpty()) {
                        System.out.println("Stack is empty.");
                        break;
                    }
                    int sum = 0, largest = numbers.get(0), smallest = numbers.get(0);
                    int even = 0, odd = 0, positive = 0, negative = 0, zeros = 0;
                    for (int number : numbers) {
                        sum += number;
                        if (number > largest) largest = number;
                        if (number < smallest) smallest = number;
                        if (number % 2 == 0) even++; else odd++;
                        if (number > 0) positive++; else if (number < 0) negative++; else zeros++;
                    }
                    System.out.println("Total elements: " + numbers.size());
                    System.out.println("Sum: " + sum);
                    System.out.println("Average: " + (double) sum / numbers.size());
                    System.out.println("Largest: " + largest);
                    System.out.println("Smallest: " + smallest);
                    System.out.println("Even numbers: " + even);
                    System.out.println("Odd numbers: " + odd);
                    System.out.println("Positive numbers: " + positive);
                    System.out.println("Negative numbers: " + negative);
                    System.out.println("Zeros: " + zeros);
                    break;
                case 6: System.out.println("Program ended."); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 6);
        scanner.close();
    }
}
