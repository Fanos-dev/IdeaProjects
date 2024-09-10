import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


public class Question2 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        Scanner input = new Scanner(System.in);
        try {
            // The filename is Test.java
            System.out.print("Please enter a file name: ");
            String fileName = input.nextLine();
            File file = new File(fileName);
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        String str = "";
        while (input.hasNextLine()) {
            str += input.nextLine();
        }

        char current = ' ';
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!stack.isEmpty()) {
                current = stack.peek();
            }

            if (ch == '(' || ch == '{' || ch == '[' || ch == ')' || ch == '}' || ch == ']') {
                if (current == '(' && ch == ')') {
                    stack.pop();
                } else if (current == '{' && ch == '}') {
                    stack.pop();
                } else if (current == '[' && ch == ']') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("The program has the correct pairs of grouping symbols");
        } else {
            System.out.println("ERROR: The program does not have the correct pairs of grouping symbols");
        }
    }
}
