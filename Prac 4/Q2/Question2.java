import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


public class Question2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        
        Scanner input = null;
        try {
            File file = new File("Test.java");
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        String str = "";
        while (input.hasNextLine()) {
            str += input.nextLine();
        }
        String current = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!stack.isEmpty()) {
                current = stack.peek();
            }

            if (ch == '(' || ch == '{' || ch == '[' || ch == ')' || ch == '}' || ch == ']') {
                if (current.equals("(") && ch == ')') {
                    stack.pop();
                } else if (current.equals("{") && ch == '}') {
                    stack.pop();
                } else if (current.equals("[") && ch == ']') {
                    stack.pop();
                } else {
                    stack.push(String.valueOf(ch));

                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Works");
        } else {
            System.out.println("Not Works");
        }
    }
}
