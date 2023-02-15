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

        System.out.println(linkedList.getLength());

        linkedList.printLinkedList();
    }
}
