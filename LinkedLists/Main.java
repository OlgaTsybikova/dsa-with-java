package LinkedLists;

public class Main {
  public static void main(String[] args) {
    /*
     * LinkedList myLinkedList = new LinkedList(0);
     * myLinkedList.append(1);
     * myLinkedList.append(2);
     * myLinkedList.append(3);
     * myLinkedList.reverse();
     * /* myLinkedList.insert(1, 5);
     * myLinkedList.remove(2);
     */
    /*
     * System.out.println(myLinkedList.set(2, 20));
     * myLinkedList.printList();
     * 
     * /* myLinkedList.getHead();
     * myLinkedList.getTail();
     * myLinkedList.getLength();
     * System.out.println(myLinkedList.get(0).value);
     */

    /* myLinkedList.prepend(6); */

    /*
     * //(2) Items - Returns 2 Node
     * System.out.println(myLinkedList.removeLast().value);
     * //(1) Items - Returns 1 Node
     * System.out.println(myLinkedList.removeLast().value);
     * //(0) Items - Returns null
     * System.out.println(myLinkedList.removeLast());
     */

    /*
     * //(2) Items - Returns 2 Node
     * System.out.println(myLinkedList.removeFirst().value);
     * //(1) Items - Returns 1 Node
     * System.out.println(myLinkedList.removeFirst().value);
     * //(0) Items - Returns null
     * System.out.println(myLinkedList.removeFirst());
     */
    LinkedList myLinkedList = new LinkedList(1);
    myLinkedList.append(2);
    myLinkedList.append(3);
    myLinkedList.append(4);
    myLinkedList.append(5);

    System.out.println("1 -> 2 -> 3 -> 4 -> 5");
    System.out.println("Middle Node: " + myLinkedList.findMiddleNode().value);

    myLinkedList.append(6);

    System.out.println("===========================");
    System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
    System.out.println("Middle Node: " + myLinkedList.findMiddleNode().value);
  }

}
