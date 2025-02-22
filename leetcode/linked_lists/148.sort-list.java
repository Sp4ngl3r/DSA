package linked_lists;

/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode dummy = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }

            dummy = dummy.next;
        }

        if (l1 != null) {
            dummy.next = l1;
        }

        if (l2 != null) {
            dummy.next = l2;
        }

        return l.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        /// Split the linked list into half
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        /// Sort each part separately
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        /// Merge the separate parts
        return mergeLists(l1, l2);
    }
}
// @lc code=end
