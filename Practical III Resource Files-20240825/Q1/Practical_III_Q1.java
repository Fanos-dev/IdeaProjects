import java.util.ArrayList;
import java.util.Scanner;

public class Practical_III_Q1{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a series of numbers ending with 0: ");

    ArrayList<Integer> arr = new ArrayList<>();
    //Adds number to arr, runs n times
    while (true) {
      int number = input.nextInt();
      arr.add(number);
      if (number == 0) break;
    }

    int currMax = 0;
    int currNum = 0;
    int max = 0;
    int num = 0;
    //Checks for longest subsequence
    if (arr.get(arr.size() - 1) == 0) {
      for (int i = 0; i < arr.size(); i++) {
        if (currMax > max) {
          max = currMax;
          num = currNum;
        }
        if (arr.get(i) != currNum) {
          currNum = arr.get(i);
          currMax = 0;
        }
        currMax++;
      }
      System.out.println("The longest same number sequence begins at index " + arr.indexOf(num) + " with " + max + " values of " + num);
    } else {
      System.out.println("Enter correct sequence");
    }
  }
}