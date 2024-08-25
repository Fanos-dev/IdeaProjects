import java.util.Iterator;
public class MinHeap<E extends Comparable<E>>  implements Iterable<E>{
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

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
                break;
            }
            currentIndex = parentIndex;
        }
    }

    /** Remove the root from the heap */
    public E remove() {
        if (list.isEmpty()) return null;

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the min between two children
            if (leftChildIndex >= list.size()) break; // The tree is a heap

            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (c.compare(list.get(maxIndex),
                        list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is less than the maximum
            if (c.compare(list.get(currentIndex),
                    list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
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
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

        //Add your code for a HeapIterator that implemenents the hasNext() and the next() methods

    }
}
