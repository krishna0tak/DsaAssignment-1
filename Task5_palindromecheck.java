import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String original_string = "madam";
        String reversed_string = "";
        Stack<Character> stack = new Stack<>();

        // Push all characters to stack
        for (int i = 0; i < original_string.length(); i++) {
            stack.push(original_string.charAt(i));
        }

        // Pop characters to form reversed string
        while (!stack.isEmpty()) {
            reversed_string += stack.pop();
        }

        // Compare strings using equals()
        if (original_string.equals(reversed_string)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
