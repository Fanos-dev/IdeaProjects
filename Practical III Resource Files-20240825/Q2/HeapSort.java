import java.util.ArrayList;
import java.util.List;

public class HeapSort {
    /** Heap sort method that sorts elements in a given list */
    public static <E extends Comparable<E>> void heapSort(List<E> list) {
        // Create a Heap of integers
        MinHeap<E> heap = new MinHeap<>();

        // Add elements to the heap
        for (int i = 0; i < list.size(); i++)
            heap.add(list.get(i));

        // Remove elements from the heap
        for (int i = 0; i < list.size(); i++)
            list.set(i, heap.remove());
    }

    /** A test method */
    public static void main(String[] args) {
        ArrayList<Patient> list = new ArrayList<Patient>();
        list.add(new Patient("John", 8));
        list.add(new Patient("Jim", 1));
        list.add(new Patient("Tim", 5));
        list.add(new Patient("Cindy", 7));
        list.add(new Patient("Mcebo", 6));
        list.add(new Patient("Phiwa", 3));
        list.add(new Patient("Londiwe", 4));
        list.add(new Patient("Musa", 2));

        heapSort(list);
		
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
    }
}