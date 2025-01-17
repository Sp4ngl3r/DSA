package linked_lists;

/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head, fast = head, previous = null, temp = null;

        // find the middle node of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of the list
        while (slow != null) {
            temp = slow.next;
            slow.next = previous;
            previous = slow;
            slow = temp;
        }

        // check for palindrome
        // since slow pointer would be null, use previous pointer
        // to get the starting pointer from the last node
        ListNode left = head, right = previous;
        while (right != null) {
            if(left.val!=right.val){
                return false;
            }

            left = left.next;
            right= right.next;
        }

        return true;
    }
}
// @lc code=end
