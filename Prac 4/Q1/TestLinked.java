import java.util.ListIterator;

public class TestLinked {
    public static void main(String[] args) {
        MyTwoWayLinkedList<Integer> list = new MyTwoWayLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);

        list.add(0,4);
        list.add(1,5);
        System.out.println(list);

        ListIterator<Integer> l = list.listIterator();
        while (l.hasNext()) {
            System.out.print(l.next() + " ");
        }
        //list.traverseBackwards();
    }
}
