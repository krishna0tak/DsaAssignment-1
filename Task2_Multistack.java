import java.util.Scanner;

class MultiStack {
    private int[] array;
    private int max;
    private int topA, topB;

    public MultiStack(int max) {
        this.max = max;
        array = new int[max];
        topA = -1;
        topB = max;
    }


    public void pushA(int value) {
        if (topA < topB - 1) {
            array[++topA] = value;
            System.out.println("Pushed " + value + " to Stack A");
        } else {
            System.out.println("Stack Overflow !");
        }
    }

    public void pushB(int value) {
        if (topA < topB - 1) {
            array[--topB] = value;
            System.out.println(" Pushed " + value + " to Stack B");
        } else {
            System.out.println(" Stack Overflow!");
        }
    }

    public void pop1() {
        if (topA >= 0) {
            System.out.println(" Popped from Stack A: " + array[topA--]);
        } else {
            System.out.println("Stack Underflow !");
        }
    }

    public void pop2() {
        if (topB < max) {
            System.out.println("Popped from Stack B: " + array[topB++]);
        } else {
            System.out.println(" Stack Underflow !");
        }
    }

    public void displayStacks() {
        System.out.print(" Stack A: ");
        if (topA == -1) {
            System.out.print("Empty");
        } else {
            for (int i = 0; i <= topA; i++) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();

        System.out.print(" Stack B: ");
        if (topB == max) {
            System.out.print("Empty");
        } else {
            for (int i = max - 1; i >= topB; i--) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total size of array: ");
        int max = scanner.nextInt();


        MultiStack stacks = new MultiStack(max);
        int choice;

        do {
            System.out.println("\n--- multi stack ---");
            System.out.println("1. Push to Stack A");
            System.out.println("2. Push to Stack B");
            System.out.println("3. Pop from Stack A");
            System.out.println("4. Pop from Stack B");
            System.out.println("5. Display Stacks");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push to Stack A: ");
                    int val1 = scanner.nextInt();
                    stacks.pushA(val1);
                    break;
                case 2:
                    System.out.print("Enter value to push to Stack 2: ");
                    int val2 = scanner.nextInt();
                    stacks.pushB(val2);
                    break;
                case 3:
                    stacks.pop1();
                    break;
                case 4:
                    stacks.pop2();
                    break;
                case 5:
                    stacks.displayStacks();
                    break;
                case 6:
                    System.out.println("Exiting..");
                    break;
                default:
                    System.out.println(" Invalid choice");
            }
        } while(choice != 6);

        scanner.close();
    }
}
