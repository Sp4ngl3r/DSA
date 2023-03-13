package doubly_linked_list;

public class DoublyLinkedListRunner {
    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.printDoublyLinkedList();

        doublyLinkedList.insertAtEnd(7);
        doublyLinkedList.insertAtEnd(5);
        doublyLinkedList.insertAtEnd(2);
        doublyLinkedList.insertAtEnd(3);

        doublyLinkedList.printDoublyLinkedList();

        doublyLinkedList.removeFromEnd();
        doublyLinkedList.removeFromEnd();

        doublyLinkedList.printDoublyLinkedList();

        doublyLinkedList.insertAtFirst(8);
        doublyLinkedList.insertAtFirst(6);

        doublyLinkedList.printDoublyLinkedList();

        doublyLinkedList.removeFromFirst();

        doublyLinkedList.printDoublyLinkedList();

        doublyLinkedList.setNode(1, 6);

        doublyLinkedList.printDoublyLinkedList();

        doublyLinkedList.insertNode(3, 3);

        doublyLinkedList.printDoublyLinkedList();

        doublyLinkedList.removeNode(2);

        doublyLinkedList.printDoublyLinkedList();


    }
}
