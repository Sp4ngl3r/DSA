package linked_lists;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    class DoublyLinkedListNode {
        int key;
        int value;
        DoublyLinkedListNode left;
        DoublyLinkedListNode right;
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DoublyLinkedListNode node) {
        node.left = head;
        node.right = head.right;

        head.right.left = node;
        head.right = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DoublyLinkedListNode node) {
        DoublyLinkedListNode left = node.left;
        DoublyLinkedListNode right = node.right;

        left.right = right;
        right.left = left;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DoublyLinkedListNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private DoublyLinkedListNode popTail() {
        DoublyLinkedListNode removedNode = tail.left;
        this.removeNode(removedNode);
        return removedNode;
    }

    private Map<Integer, DoublyLinkedListNode> cache = new HashMap<Integer, DoublyLinkedListNode>();
    private int count;
    private int capacity;
    private DoublyLinkedListNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DoublyLinkedListNode();
        head.left = null;

        tail = new DoublyLinkedListNode();
        tail.right = null;

        head.right = tail;
        tail.left = head;
    }

    public int get(int key) {

        DoublyLinkedListNode node = cache.get(key);
        if (node == null) {
            return -1; // should raise exception here.
        }

        // move the accessed node to the head
        this.moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DoublyLinkedListNode node = cache.get(key);

        if (node == null) {

            DoublyLinkedListNode newNode = new DoublyLinkedListNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                // pop the tail
                DoublyLinkedListNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
