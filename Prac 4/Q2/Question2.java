import java.util.Stack;

public class Question2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        String str = "(Vishar{arli)n}0";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(String.valueOf(ch));
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Works");
        } else {
            System.out.println("Not Works");
        }
    }
}
