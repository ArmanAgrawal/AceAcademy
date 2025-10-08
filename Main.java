import java.util.Scanner;

/**
 * @filename - Main.java
 * @description - Entry point for string operations
 * @author - Arman
 */

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter initial string: ");
        String s = userInput.nextLine();
        MyString value = new MyString(s);

        int choice;

        do {
            System.out.println("""
                    Choose operation:
                    1. Append
                    2. Count Words
                    3. Replace
                    4. Check Palindrome
                    5. Splice
                    6. Split
                    7. Max Repeating Character
                    8. Sort
                    9. Shift
                    10. Reverse
                    0. Exit
                    """);
            System.out.print("Enter your choice: ");

            choice = userInput.nextInt();
            userInput.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter string to append: ");
                    System.out.println(value.append(userInput.nextLine()));
                    break;

                case 2:
                    System.out.println("Word count: " + value.countWord());
                    break;

                case 3:
                    System.out.print("Enter target substring: ");
                    String target = userInput.nextLine();
                    System.out.print("Enter replacement string: ");
                    String replacement = userInput.nextLine();
                    System.out.println(value.replace(target, replacement));
                    break;

                case 4:
                    System.out.println(value.isPalindrome() ? "Palindrome" : "Not Palindrome");
                    break;

                case 5:
                    System.out.print("Enter start index: ");
                    int start = userInput.nextInt();
                    System.out.print("Enter length to remove: ");
                    int length = userInput.nextInt();
                    userInput.nextLine();
                    System.out.println(value.splice(start, length));
                    break;

                case 6:
                    System.out.print("Enter delimiter: ");
                    String delimiter = userInput.nextLine();
                    String[] parts = value.split(delimiter);
                    System.out.println("Split parts:");
                    for (String part : parts)
                        System.out.println(part);
                    break;

                case 7:
                    System.out.println(value.getMaximumRepeatChar());
                    break;

                case 8:
                    System.out.println(value.sort());
                    break;

                case 9:
                    System.out.print("Enter number of characters to shift: ");
                    int n = userInput.nextInt();
                    userInput.nextLine();
                    System.out.println(value.shift(n));
                    break;

                case 10:
                    System.out.println(value.reverse());
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);

        userInput.close();
    }
}