package doubly_linked_list;

public class DoublyLinkedList {

    static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void insertAtFirst(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        this.length++;
        System.out.println("Node " + newNode.value + " is being added to the beginning of the Doubly Linked List");
    }

    public void insertAtEnd(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        this.length++;
        System.out.println("Node " + newNode.value + " is being added to the end of the Doubly Linked List");
    }

    public boolean insertNode(int index, int value) {

        if (index < 0 || index > this.length) {
            System.out.println("Specified index is not within the range of Doubly Linked List");
            return false;
        }

        if (index == length) {
            insertAtEnd(value);
            return true;
        }

        Node newNode = new Node(value);

        if (index == 0) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } else {
            Node beforeNode = head;

            for (int i = 0; i < index - 1; i++)
                beforeNode = beforeNode.next;

            Node afterNode = beforeNode.next;
            newNode.next = afterNode;
            newNode.prev = beforeNode;
            beforeNode.next = newNode;
            afterNode.prev = newNode;
        }

        System.out.println("Node " + newNode.value + " is being added to Doubly Linked List at the position of " + index);
        this.length++;
        return true;
    }

    public Node removeFromFirst() {
        if (head == null) {
            System.out.println("The Doubly Linked List is empty");
            return null;
        }

        Node removedNode = head;

        if (length == 1 || head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        removedNode.next = null;
        this.length--;
        System.out.println("Node " + removedNode.value + " is being removed from the beginning of the Doubly Linked List");
        return removedNode;
    }

    public Node removeFromEnd() {
        if (head == null) {
            System.out.println("The Doubly Linked List is empty");
            return null;
        }

        Node removedNode = tail;

        if (head.next == null || length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            removedNode.prev = null;
        }

        this.length--;
        System.out.println("Node " + removedNode.value + " is being removed from the end of the Doubly Linked List");
        return removedNode;
    }

    public Node removeNode(int index) {

        if (index < 0 || index >= length) {
            System.out.println("Specified index is not within the range of Doubly Linked List");
            return null;
        }

        if (index == 0)
            return removeFromFirst();

        if (index == length - 1)
            return removeFromEnd();

        Node removedNode = getNode(index);

        removedNode.next.prev = removedNode.prev;
        removedNode.prev.next = removedNode.next;
        removedNode.next = null;
        removedNode.prev = null;

        this.length--;
        System.out.println("Node " + removedNode.value + " is being removed from Doubly Linked List at the position of " + index);
        return removedNode;
    }

    public void printDoublyLinkedList() {

        System.out.print("Doubly Linked List contains >>>> null <-> ");

        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.value + " <-> ");
            tempNode = tempNode.next;
        }

        System.out.print("null\n");
    }

    public Node getNode(int index) {
        if (index < 0 || index >= this.length) {
            System.out.println("Specified index is not within the range of Doubly Linked List");
            return null;
        }

        Node tempNode = head;

        if (index < this.length / 2) {
            for (int i = 0; i < index; i++)
                tempNode = tempNode.next;

        } else {
            tempNode = tail;
            for (int i = length - 1; i > index; i--)
                tempNode = tempNode.prev;
        }
        return tempNode;
    }

    public boolean setNode(int index, int value) {
        if (index < 0 || index >= this.length) {
            System.out.println("Specified index is not within the range of Doubly Linked List");
            return false;
        }

        Node tempNode = head;

        if (index < this.length / 2) {
            for (int i = 0; i < index; i++)
                tempNode = tempNode.next;

        } else {
            tempNode = tail;
            for (int i = length - 1; i > index; i--)
                tempNode = tempNode.prev;
        }

        tempNode.value = value;
        return true;
    }

    public int getLength() {
        return this.length;
    }
}
