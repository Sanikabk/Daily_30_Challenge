import java.util.*;

public class PostfixEvaluation {
    public static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();
        for (String token : expr.split(" ")) {
            if ("+-*/".contains(token) && token.length() == 1) {
                int b = stack.pop(), a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } else stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        System.out.println(evaluatePostfix(expr));
    }
}
