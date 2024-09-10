import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class MyTwoWayLinkedList<E> extends AbstractSequentialList<E>{
    private DLLNode<E> head, tail;
    private int size =0;

    /** Create a default list */
    public MyTwoWayLinkedList() {
    }

    /** Create a list from an array of objects */
    public MyTwoWayLinkedList(E[] objects) {
        for (E e : objects)
            add(e);
    }

    /** Return the head element in the list */
    public E getFirst() {
        if (size == 0) {
            return null;
        }
        else {
            return head.element;
        }
    }

    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) {
            return null;
        }
        else {
            return tail.element;
        }
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        //add your code here
        if (tail == null){
            head = new DLLNode<>(e, null, null);
            tail = head;
        } else {
            DLLNode<E> newNode = new DLLNode<>(e, head, null);
            head = newNode;
            newNode.next.previous = newNode;
        }
        size++;
    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        //add your code here
        if(tail == null){
            DLLNode<E> newNode = new DLLNode<>(e, null, null);
            head = newNode;
            tail = head;
            newNode.previous = newNode;
        } else {
            DLLNode<E> newNode = new DLLNode<>(e, null, tail);
            tail = newNode;
            tail.previous.next = newNode;
        }
        size++;
    }

    /**
     * Add a new element at the specified index in this list The index of the
     * head element is 0
     */
    public void add(int index, E e) {
        //Add your code here
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        if (index == 0){
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            DLLNode<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new DLLNode<>(e, current.next, current);
            current.next.next.previous = current.next;
            size++;
        }
    }

    /**
     * Remove the head node and return the object that is contained in the
     * removed node.
     */
    public E removeFirst() {
		//Add your code here.
        if (size == 0) {
            return null;
        } else if (size == 1) {
            DLLNode<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else{
            DLLNode<E> temp = head;
            head = head.next;
            head.previous = null;
            size--;
            return temp.element;
        }
    }

    /**
     * Remove the last node and return the object that is contained in the
     * removed node.
     */
    public E removeLast() {
        if (size == 0) {
            return null;
        }
        else if (size == 1) {
            DLLNode<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }
        else {
            DLLNode<E> temp = tail;
            tail = tail.previous;
            tail.next= null;
            size--;
            return temp.element;
        }
    }

    /**
     * Remove the element at the specified position in this list. Return the
     * element that was removed from the list.
     */
    public E remove(int index) {
		//add code here. Remember to take care of the return null statement below
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            DLLNode<E> current = head;
            for (int i = 0 ; i < index; i++) {

            }
        }
        return null; // replace this with the correct return statement
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        DLLNode<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            }
            else {
                result.append("]"); // Insert the closing [] in the string
            }
        }

        return result.toString();
    }

    /** Clear the list */
    public void clear() {
        head = tail = null;
    }

    /** Return true if this list contains the element o */
    public boolean contains(Object e) {
        for(DLLNode<E> current = head; current!=null; current = current.next){
            if(current.element.equals(e))
            {
                return true;
            }
        }
        return false;
    }

    /** Return the element from this list at the specified index */
    public E get(int index) {
        if (index < 0 || index > size-1 )
            throw new IndexOutOfBoundsException
                    ("Index: " + index + ", Size: " + size);
        DLLNode current = head;
        for(int i= 0; i< index;i++)
            current = current.next;
        return (E)current.element;
    }

    /**
     * Return the index of the head matching element in this list. Return -1 if
     * no match.
     */
    public int indexOf(Object e) {
        int i=0;
        for(DLLNode<E> current = head; current!=null; current = current.next){
            if(e==current.element)
                return i;
            i++;
        }
        if (i < 0 || i > size-1 )
            return -1;
        else
            return i;
    }

    /**
     * Return the index of the last matching element in this list Return -1 if
     * no match.
     */
    public int lastIndexOf(Object e) {
        int i=0;
        int n = -1;
        for(DLLNode<E> current = head; current!=null; current = current.next){
            if(e==current.element)
                n=i;
            i++;
        }
        return n;
    }

    /**
     * Replace the element at the specified position in this list with the
     * specified element.
     */
    public E set(int index, E e) {
        if (index < 0 || index > size +1)
        {
            throw new IndexOutOfBoundsException
                    ("Index: " + index + ", Size: " + size);
        }
        else{
            DLLNode<E> current = head;
            for(int i= 0; i< index -1;i++)
                current = current.next;
            current.next = new DLLNode<E>(e, current.next.next, current.next.next.previous);
        }
        return e;
    }
    /*Traverses the list from the tail to the head  */
    public void traverseBackwards() {
        ListIterator<E> itr = new LinkedListIterator<>(size -1);
        while (itr.hasPrevious()) {
            System.out.print(itr.previous() + " ");
        }
    }

    /** Override the iterator method defined in Iterable */
    public ListIterator<E> iterator() {
        return new LinkedListIterator<E>();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new LinkedListIterator<E>(index);
    }

    public int size() {
        return size;
    }

    private class DLLNode<E> {
        E element;
        DLLNode<E> next;
        DLLNode<E> previous;
        public DLLNode(){
            next =null;
        }
        public  DLLNode(E el, DLLNode<E> nxt, DLLNode <E> prev){
            element= el;
            next = nxt;
            previous = prev;
        }
    }

    private class LinkedListIterator<E> implements ListIterator<E> {
        private DLLNode<E> current = (DLLNode<E>)head; // Current index
        int index = 0;
        public LinkedListIterator() {

        }

        public LinkedListIterator(int index) {
            if (index < 0 || index > size)
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
                        + size);
            for (int nextIndex = 0; nextIndex < index; nextIndex++)
                current = current.next;
        }
        @Override
        public boolean hasNext() {
            
			//Add your code here;
			
			return false; // replace this with the correct return statement
        }
        @Override
        public E next() {
			
            //add your code here
            
			return null; // replace this with the correct return statement
        }
        @Override
        public boolean hasPrevious() {
            
			//add your code here
			
			return false;// replace this with the correct return statement
        }
        @Override
        public E previous() {
            
			
			//add your code here
			
            return null; // replace this with the correct return statement
        }

        public void remove() {
            System.out.println("Implementation left as an exercise");
        }

        public void add(E e) {
            System.out.println("Implementation left as an exercise");
        }
        public int nextIndex() {
            System.out.println("Implementation left as an exercise");
            return 0;
        }
        public int previousIndex() {
            System.out.println("Implementation left as an exercise");
            return 0;
        }

        @Override
        public void set(E e) {
            current.element = e;
        }
    }


}


