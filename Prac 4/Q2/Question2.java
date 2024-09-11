import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


public class Question2 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        // Handles the input of the source file
        Scanner input = new Scanner(System.in);
        try {
            // The filename is Test.java
            System.out.print("Please enter a file name: ");
            String fileName = input.nextLine();
            File file = new File(fileName);
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
        }

        // Add every line of the source file to a string
        String str = "";
        while (input.hasNextLine()) {
            str += input.nextLine();
        }

        // Check for any overlaps
        char current = ' ';
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Check if stack has elements before peeking
            if (!stack.isEmpty()) {
                current = stack.peek();
            }

            // Pop the top element from stack if current and ch are a pair
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

        // If stack is empty no overlaps occurred
        if (stack.isEmpty()) {
            System.out.println("The program has the correct pairs of grouping symbols");
        } else {
            System.out.println("ERROR: The program does not have the correct pairs of grouping symbols");
        }
    }
}
