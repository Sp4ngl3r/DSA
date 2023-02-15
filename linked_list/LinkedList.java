package linked_list;

public class LinkedList {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void addAtFirst(int value) {

        Node tempNode = new Node(value);

        if (length == 0) {
            head = tempNode;
            tail = tempNode;
        } else {
            tempNode.next = head;
            head = tempNode;
        }

        length++;
        System.out.println("Node " + tempNode.value + " is being added to Linked List");
    }

    public void addAtLast(int value) {

        Node tempNode = new Node(value);

        if (length == 0) {
            head = tempNode;
            tail = tempNode;
        } else {
            tail.next = tempNode;
            tail = tempNode;
        }

        length++;
        System.out.println("Node " + tempNode.value + " is being added to Linked List");
    }

    public void printLinkedList() {

        System.out.print("Linked List contains >>>> ");

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.print("null\n");
    }

    public int getLength() {
        return this.length;
    }
}


