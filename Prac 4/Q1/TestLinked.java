public class TestLinked {
    public static void main(String[] args) {
        MyTwoWayLinkedList<Integer> list = new MyTwoWayLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);

        list.add(0,4);
        list.add(1,5);
        list.removeLast();
        System.out.println(list);
    }
}
