import java.util.ArrayList;
import java.util.Stack;

public class ReverseListUsingStack {
    public static void main(String[] args) {

        ArrayList<Integer> originalList = new ArrayList<>();
        originalList.add(100);
        originalList.add(101);
        originalList.add(102);
        originalList.add(103);

        System.out.println("Original List: " + originalList);

        Stack<Integer> stack = new Stack<>();


        for (int num : originalList) {
            stack.push(num);
        }


        ArrayList<Integer> reversedList = new ArrayList<>();
        while (!stack.isEmpty()) {
            reversedList.add(stack.pop());
        }

        System.out.println("Reversed List: " + reversedList);
    }
}
