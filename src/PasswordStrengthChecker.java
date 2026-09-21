import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        // Read the initial password from the user.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        if (password.length() <= 0) {
            System.out.println("Invalid password.");
            scanner.close();
            return;
        }

        int choice;
        // Repeatedly display and process the menu.
        do {
            System.out.println("\n1. Enter Password\n2. Check Password Length\n3. Analyze Password Characters");
            System.out.println("4. Check Password Strength\n5. Convert Password Format\n6. Display Password Report\n7. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            int[] counts = countCharacters(password);

            switch (choice) {
                case 1:
                    System.out.print("Enter a new password: ");
                    password = scanner.nextLine();
                    System.out.println(password.equals("") ? "Invalid password." : "Password saved successfully.");
                    break;
                case 2:
                    System.out.println("Total characters: " + password.length());
                    System.out.println(password.length() < 8 ? "Password is too short." : "Password length is acceptable.");
                    break;
                case 3:
                    displayCounts(counts);
                    break;
                case 4:
                    System.out.println(getStrength(password, counts));
                    break;
                case 5:
                    System.out.println("Uppercase: " + password.toUpperCase());
                    System.out.println("Lowercase: " + password.toLowerCase());
                    break;
                case 6:
                    System.out.println("Password length: " + password.length());
                    System.out.println("First character: " + password.charAt(0));
                    System.out.println("Last character: " + password.charAt(password.length() - 1));
                    displayCounts(counts);
                    System.out.println("Strength: " + getStrength(password, counts));
                    System.out.println("Contains a digit: " + containsDigit(password));
                    System.out.println("Starts with uppercase: " + password.startsWith(password.substring(0, 1).toUpperCase()));
                    System.out.println("Ends with digit: " + Character.isDigit(password.charAt(password.length() - 1)));
                    System.out.println("Contains @: " + password.contains("@"));
                    break;
                case 7:
                    System.out.println("Program ended.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 7);
        scanner.close();
    }

    private static int[] countCharacters(String password) {
        // Count every password character by category.
        int[] counts = new int[4];
        for (int index = 0; index < password.length(); index++) {
            char character = password.charAt(index);
            if (Character.isUpperCase(character)) counts[0]++;
            else if (Character.isLowerCase(character)) counts[1]++;
            else if (Character.isDigit(character)) counts[2]++;
            else counts[3]++;
        }
        return counts;
    }

    private static boolean containsDigit(String password) {
        for (int index = 0; index < password.length(); index++) {
            if (Character.isDigit(password.charAt(index))) return true;
        }
        return false;
    }

    private static String getStrength(String password, int[] counts) {
        int conditions = 0;
        if (counts[0] > 0) conditions++;
        if (counts[1] > 0) conditions++;
        if (counts[2] > 0) conditions++;
        if (counts[3] > 0) conditions++;
        if (password.length() >= 8) conditions++;
        if (conditions == 5) return "Strong Password";
        if (conditions >= 3) return "Medium Password";
        return "Weak Password";
    }

    private static void displayCounts(int[] counts) {
        System.out.println("Uppercase letters: " + counts[0]);
        System.out.println("Lowercase letters: " + counts[1]);
        System.out.println("Digits: " + counts[2]);
        System.out.println("Special characters: " + counts[3]);
    }
}
