import java.util.*;

public class Question3 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        //Generates 10 random numbers
        for (int i = 0; i < 10; i++){
            queue.add((int) (Math.random() * 20));
        }
        System.out.println("Original Queue: " + queue);

        //Finds max integer
        int max = 0;
        for (int i = 0; i < queue.size(); i++){
            int value = queue.poll();
            if(value>max){
                max = value;
            }
            queue.add(value);
        }

        System.out.println("Max integer in queue: " + max);
        System.out.println("Original Queue: " + queue);
    }
}
