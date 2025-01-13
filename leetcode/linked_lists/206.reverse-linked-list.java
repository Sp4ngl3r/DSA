package linked_lists;

/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {

        // Iterative solution
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            // Save the next node
            ListNode temp = current.next;
            // Reverse the current node
            current.next = prev;
            // Move the pointers
            prev = current;
            current = temp;
        }

        return prev;
    }
}
// @lc code=end
