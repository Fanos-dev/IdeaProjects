import java.util.ArrayList;
import java.util.Iterator;

public class TestPriorityQueue {
    public static void main(String[] args) {
		/*Please note that priority is defined in the ranking order. Thus, 
		a patient with the highest priority has priority value of 1.
		*/
        PriorityQueue<Patient> priorityQueue = new PriorityQueue<Patient>();
        priorityQueue.enqueue(new Patient("John", 8));
        priorityQueue.enqueue(new Patient("Jim", 1));
        priorityQueue.enqueue(new Patient("Tim", 5));
        priorityQueue.enqueue(new Patient("Cindy", 7));
        priorityQueue.enqueue(new Patient("Mcebo", 6));
        priorityQueue.enqueue(new Patient("Phiwa", 3));
        priorityQueue.enqueue(new Patient("Londiwe", 4));
        priorityQueue.enqueue(new Patient("Musa", 2));

        System.out.println("The patient with the highest priority is: " + priorityQueue.peek());

        System.out.println("Elements in the underlying container: " + priorityQueue.listElements());

        System.out.print("Elements in priority order: ");
        while (priorityQueue.getSize() > 0){
            System.out.print(priorityQueue.dequeue() + " ");
        }
    }

}