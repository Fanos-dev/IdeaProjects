import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

//        Collections.addAll(arr, 2, 4, 4, 8, 8, 8, 8, 2, 4, 4, 0);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a series of numbers ending with 0: ");
        //Adds number to arr, runs n times
        while (true) {
            int input = sc.nextInt();
            arr.add(input);
            if (input == 0) break;
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
