import java.util.*;

public class ReverseStackRecursively {
    public static void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            reverse(stack);
            insertAtBottom(stack, top);
        }
    }

    private static void insertAtBottom(Stack<Integer> stack, int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, val);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        reverse(stack);
        System.out.println(stack);
    }
}
