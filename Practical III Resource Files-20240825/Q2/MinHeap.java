import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinHeap<E extends Comparable<E>>  implements Iterable<E>{
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    /** Create a default min-heap */
    public MinHeap() {
    }

    /** Create a min-heap from an array of objects */
    public MinHeap(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }
	public E getFirst(){
        return list.get(0);
    }

    /** Add a new object into the heap */
    public void add(E newObject) {
		//Add your code here
		list.add(newObject);
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) < 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else {
                break; //The tree is a heap
            }
            currentIndex = parentIndex;
        }
    }

    /** Remove the root from the heap */
    public E remove() {
        if (list.isEmpty()) {
            return null;
        }

        // Root element removed, move last element to root, remove last element
        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            // Children
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the min between the two children
            if (leftChildIndex >= list.size()) {
                break; // The tree is a heap
            }

            int minIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(minIndex).compareTo(list.get(rightChildIndex)) > 0) {
                    minIndex = rightChildIndex;
                }
            }

            // Swap if the current node is greater than the maximum
            if (list.get(currentIndex).compareTo(list.get(minIndex)) > 0) {
                E temp = list.get(minIndex);
                list.set(minIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = minIndex;
            }
            else
                break; // The tree is a heap
        }
        return removedObject;
    }
    /** get a queue iterator */
    public java.util.Iterator<E> iterator() {
        return new HeapIterator();
    }

    /** Get the number of nodes in the heap */
    public int getSize() {
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
    private class HeapIterator implements Iterator<E> {
        //Add your code for a HeapIterator that implements the hasNext() and the next() methods
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < list.size();
        }

        @Override
        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return list.get(currentIndex++);
        }
    }
}
