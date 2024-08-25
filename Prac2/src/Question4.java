import java.util.Scanner;
import java.util.Stack;

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Gets input from user
        System.out.print("Enter an equation: ");
        String[] input = sc.nextLine().split(" ");

        //Create stack
        Stack<Integer> stack = new Stack<>();

        //Get integers in stack and perform operations
        for (String str : input){
            //Converts string to characters and compare if only integers
            if (str.chars().allMatch(Character::isDigit)){
                stack.push(Integer.parseInt(str));
            } else {
                //Get top two integers in stack and perform operations
                int x = stack.pop();
                int y = stack.pop();

                //Operations
                switch (str){
                    case "+" -> stack.push(x + y);
                    case "-" -> stack.push(x - y);
                    case "*" -> stack.push(x * y);
                    case "/" -> stack.push(y / x);
                }
            }
        }
        System.out.println(stack.pop());
    }
}
