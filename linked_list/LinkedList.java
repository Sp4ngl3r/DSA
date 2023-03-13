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

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        this.length++;
        System.out.println("Node " + newNode.value + " is being added to the beginning of the Linked List");
    }

    public void addAtLast(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        this.length++;
        System.out.println("Node " + newNode.value + " is being added to the end of the Linked List");
    }

    public boolean insertNode(int index, int value) {

        if (index < 0 || index > length) {
            System.out.println("Specified index is not within the range of Linked List");
            return false;
        }

        Node newNode = new Node(value);
        if (index == 0) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        } else {
            Node tempNode = head;

            for (int i = 0; i < index - 1; i++)
                tempNode = tempNode.next;

            newNode.next = tempNode.next;
            tempNode.next = newNode;
        }
        this.length++;
        System.out.println("Node " + newNode.value + " is being added to Linked List at the position of " + index);
        return true;
    }

    public Node removeFromFirst() {
        if (head == null) {
            System.out.println("The Linked List is empty");
            return null;
        }

        Node removedNode = head;

        if (length == 1 || head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        removedNode.next = null;
        this.length--;

        System.out.println("Node " + removedNode.value + " is being removed from the beginning of the Linked List");
        return removedNode;
    }

    public Node removeFromLast() {
        if (head == null) {
            System.out.println("The Linked List is empty");
            return null;
        }

        Node removedNode = head;

        if (length == 1 || head.next == null) {
            head = null;
            tail = null;
        } else {
            Node tempNode = head;
            while (tempNode.next.next != null) {
                tempNode = tempNode.next;
            }
            removedNode = tempNode.next;
            tail = tempNode;
            tempNode.next = null;
        }
        removedNode.next = null;
        this.length--;

        System.out.println("Node " + removedNode.value + " is being removed from the end of the Linked List");
        return removedNode;
    }

    public Node removeNode(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Specified index is not within the range of Linked List");
            return null;
        }

        Node removedNode = head;

        if (index == 0) {
            if (head.next == null || length == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
        } else {
            Node tempNode = head;

            for (int i = 0; i < index - 1; i++)
                tempNode = tempNode.next;

            removedNode = tempNode.next;
            tempNode.next = removedNode.next;
        }
        removedNode.next = null;
        this.length--;

        System.out.println("Node " + removedNode.value + " is being removed from Linked List at the position of " + index);
        return removedNode;
    }

    // Reversing using 3 pointer method
    public void reverse() {
        Node tempNode = head;
        head = tail;
        tail = tempNode;

        Node afterNode = tempNode.next;
        Node beforeNode = null;

        for (int i = 0; i < length; i++) {
            afterNode = tempNode.next;
            tempNode.next = beforeNode;
            beforeNode = tempNode;
            tempNode = afterNode;
        }

        System.out.println("The Linked List has been reversed");
    }

    public void printLinkedList() {

        System.out.print("Linked List contains >>>> ");

        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.next;
        }

        System.out.print("null\n");
    }

    public Node getNode(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Specified index is not within the range of Linked List");
            return null;
        }

        Node tempNode = head;
        for (int i = 0; i < index; i++)
            tempNode = tempNode.next;

        return tempNode;
    }

    public boolean setNode(int index, int value) {
        if (index < 0 || index >= length) {
            System.out.println("Specified index is not within the range of Linked List");
            return false;
        }

        Node tempNode = head;
        for (int i = 0; i < index; i++)
            tempNode = tempNode.next;

        tempNode.value = value;
        return true;
    }

    public int getLength() {
        return this.length;
    }
}


