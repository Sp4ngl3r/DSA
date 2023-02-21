package linked_list;

public class LinkedListRunner {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.addAtLast(1);
        linkedList.addAtLast(2);
        linkedList.addAtLast(3);
        linkedList.addAtLast(4);

        linkedList.printLinkedList();

        linkedList.addAtFirst(2);
        linkedList.addAtFirst(3);
        linkedList.addAtFirst(4);

        linkedList.printLinkedList();

        linkedList.insertNode(8, 9);

        linkedList.printLinkedList();

        linkedList.removeFromFirst();
        linkedList.removeFromFirst();

        linkedList.printLinkedList();

        linkedList.reverse();

        linkedList.printLinkedList();
    }
}
