public class Test_Q1 {

    public static void main(String[] args) {
    MyTwoWayLinkedList<Integer> list = new MyTwoWayLinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    list.add(9);
    
    System.out.println("Testing the ADD methods");
    System.out.print("list :" + list);
    list.addFirst(0);
    System.out.print("\nlist :" + list);
    list.addLast(Integer.SIZE);
    System.out.print("\nlist :" + list);
    list.add(list.size()/2, Integer.SIZE);
    System.out.println("\nlist :" + list);    
    System.out.println("list size is :"+ list.size());    
    System.out.println("Element at 4 is :"+ list.get(4));
    
    System.out.println("\nTesting the REMOVE methods");
    System.out.println("Element removed :"+ list.removeFirst());
    System.out.println("list :" + list);
    System.out.println("Element removed :"+ list.removeLast());
    System.out.println("list :" + list); 
    System.out.println("Element removed :"+ list.remove(5));
    System.out.println("list :" + list);
    System.out.print("\n");
    
    System.out.println("\nlist :" + list);
    System.out.print("If all your methods are implemented correctly, this should return your" +
    " current list in the reverse order with no elements skipped or added\n");
    list.traverseBackwards();//If all your methods are implemented correctly, this should return your 
                             // current list in the reverse order with no elements skipped or added.
    }
}

