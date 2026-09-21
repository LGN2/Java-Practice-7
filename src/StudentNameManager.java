import java.util.Arrays;
import java.util.Scanner;

public class StudentNameManager {
    public static void main(String[] args) {
        // Read and store the initial student names.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int studentCount = scanner.nextInt();
        scanner.nextLine();
        if (studentCount <= 0) {
            System.out.println("Invalid number of students.");
            scanner.close();
            return;
        }

        String[] studentNames = new String[studentCount];
        for (int index = 0; index < studentCount; index++) {
            System.out.print("Enter student name " + (index + 1) + ": ");
            studentNames[index] = scanner.nextLine();
        }

        int choice;
        // Repeatedly display and process the menu.
        do {
            System.out.println("\n1. Add Student Name\n2. Search Student Name\n3. Update Student Name");
            System.out.println("4. Display All Student Names\n5. Analyze Names\n6. Compare Two Names\n7. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new student name: ");
                    String newName = scanner.nextLine();
                    boolean duplicate = false;
                    for (String name : studentNames) {
                        if (name.equals(newName)) {
                            duplicate = true;
                            break;
                        }
                    }
                    if (duplicate) {
                        System.out.println("Student name already exists.");
                    } else {
                        studentNames = Arrays.copyOf(studentNames, studentNames.length + 1);
                        studentNames[studentNames.length - 1] = newName;
                        System.out.println("Student name added successfully.");
                    }
                    break;
                case 2:
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for (String name : studentNames) {
                        if (name.equals(searchName)) {
                            found = true;
                            break;
                        }
                    }
                    System.out.println(found ? "Student found." : "Student not found.");
                    break;
                case 3:
                    System.out.print("Enter existing student name: ");
                    String existingName = scanner.nextLine();
                    System.out.print("Enter new student name: ");
                    String replacementName = scanner.nextLine();
                    boolean updated = false;
                    for (int index = 0; index < studentNames.length; index++) {
                        if (studentNames[index].equals(existingName)) {
                            studentNames[index] = replacementName;
                            updated = true;
                            break;
                        }
                    }
                    System.out.println(updated ? "Student name updated successfully." : "Student not found.");
                    break;
                case 4:
                    for (int index = 0; index < studentNames.length; index++) {
                        System.out.println((index + 1) + ". " + studentNames[index]);
                    }
                    break;
                case 5:
                    String longestName = studentNames[0];
                    String shortestName = studentNames[0];
                    int totalCharacters = 0;
                    int startsWithA = 0;
                    int endsWithA = 0;
                    for (String name : studentNames) {
                        if (name.length() > longestName.length()) longestName = name;
                        if (name.length() < shortestName.length()) shortestName = name;
                        totalCharacters += name.length();
                        if (name.startsWith("A")) startsWithA++;
                        if (name.endsWith("a")) endsWithA++;
                    }
                    System.out.println("Total students: " + studentNames.length);
                    System.out.println("Longest name: " + longestName);
                    System.out.println("Shortest name: " + shortestName);
                    System.out.println("Total characters: " + totalCharacters);
                    System.out.println("Average name length: " + (double) totalCharacters / studentNames.length);
                    System.out.println("Names starting with A: " + startsWithA);
                    System.out.println("Names ending with a: " + endsWithA);
                    System.out.println("Longest name uppercase: " + longestName.toUpperCase());
                    System.out.println("Shortest name lowercase: " + shortestName.toLowerCase());
                    System.out.println("First letter of longest name: " + longestName.charAt(0));
                    System.out.println("First part of longest name: " + longestName.substring(0, 1));
                    break;
                case 6:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter second name: ");
                    String secondName = scanner.nextLine();
                    System.out.println("equals(): " + firstName.equals(secondName));
                    System.out.println("equalsIgnoreCase(): " + firstName.equalsIgnoreCase(secondName));
                    System.out.println("compareTo(): " + firstName.compareTo(secondName));
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
}
