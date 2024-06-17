package LinkedLists;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        // create new Node
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value) {
        Node newNode = new Node(value); // create a node
        if (length == 0) { // if we have an empty linkedList
            head = newNode;
            tail = newNode;
        } else { // if we have items in the linkedList
            tail.next = newNode;
            tail = newNode;
        }
        length++;// increase the length by 1;
    }

    public Node removeLast() {
        if (length == 0)
            return null;
        Node pre = head;
        Node temp = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;

    }

    public Node removeFirst() {

        if (length == 0)
            return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) {
            tail = null;
        }

        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;
        if (index == 0) {
            prepend(value);
            return true;
        } else if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;

    }

    public Node remove(int index) {
        if (index < 0 || index > length)
            return null;

        if (index == 0) {
            return removeFirst();
        } else if (index == length - 1) {
            return removeLast();
        } else {
            /*
             * If the given index is for a node that is not the first or last node,
             * it creates a variable called prev and points it at the previous node of the
             * node to be removed.
             * Then, it creates a variable called temp and points it to the node to be
             * removed.
             * The method then sets the prev node's next pointer to the node that comes
             * after the temp node,
             * effectively removing the temp node from the linked list.
             * It sets the temp node's next pointer to null, updates the length of the
             * linked list,
             * and returns the removed node.
             */
            Node prev = get(index - 1);
            Node temp = prev.next;
            prev.next = temp.next;
            temp.next = null;
            length--;
            return temp;
        }
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node afterTemp = temp.next;
        Node beforeTemp = null;
        for (int i = 0; i < length; i++) {
            afterTemp = temp.next;
            temp.next = beforeTemp;
            beforeTemp = temp;
            temp = afterTemp;
        }
    }

    public void reverseExplicado() {
        // Set temp to the current head of the linked list
        Node temp = head;
        // Set the new head to be the current tail
        head = tail;
        // Set the new tail to be the previous head (stored in temp)
        tail = temp;

        // Set after to be the next node after the current head
        Node after = temp.next;
        // Initialize before to null, as the first node in the reversed list will not
        // have a previous node
        Node before = null;

        // Loop through the linked list, reversing the order of the nodes
        for (int i = 0; i < length; i++) {
            // Set after to be the next node after the current node
            after = temp.next;
            // Set the current node's next pointer to the previous node
            temp.next = before;
            // Set before to be the current node, as it will be the previous node in the
            // next iteration of the loop
            before = temp;
            // Set temp to be the next node in the linked list
            temp = after;
        }
    }

    public Node findMiddleNode() {
        // Initialize slow pointer to the head of the linked list
        Node slow = head;

        // Initialize fast pointer to the head of the linked list
        Node fast = head;

        // Traverse the linked list with two pointers: slow and fast
        // slow moves one node at a time, while fast moves two nodes at a time
        while (fast != null && fast.next != null) {
            // Move slow pointer to the next node
            slow = slow.next;

            // Move fast pointer to the next two nodes
            fast = fast.next.next;
        }

        // Return the Node object representing the middle node of the linked list
        return slow;
    }

    // The method should be able to detect if there is a cycle or loop present in
    // the linked list.
    // You are required to use Floyd's cycle-finding algorithm
    // (also known as the "tortoise and the hare" algorithm) to detect the loop.

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
