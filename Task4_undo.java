import java.util.Scanner;
import java.util.Stack;

public class Undo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        String currentText = "";
        int choice;

        do {

            System.out.println("\n--- Text Menu ---");
            System.out.println("1. Type Text");
            System.out.println("2. Undo Last Action");
            System.out.println("3. View Current Text");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text to type: ");
                    String typeText = scanner.nextLine();
                    stack.push(typeText);

                    currentText += typeText;

                    System.out.println(" Text added.");
                    break;

                case 2:
                    if (!stack.isEmpty()) {
                        String lastAction = stack.pop();

                        if (currentText.endsWith(lastAction)) {
                            currentText = currentText.substring(0, currentText.length() - lastAction.length());
                        }
                        System.out.println("Undo performed. Removed: " + lastAction);
                    } else {
                        System.out.println(" Nothing to undo.");
                    }
                    break;

                case 3:
                    System.out.println(" Current Text: " + currentText);
                    break;

                case 4:
                    System.out.println(" Exiting..");
                    break;

                default:
                    System.out.println(" Invalid choice");
            }
        } while (choice != 4);

        scanner.close();
    }
}
