package leetcode.linked_lists;

/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode sortedList = new ListNode();
        ListNode currentNode = sortedList;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }

            currentNode = currentNode.next;
        }

        /// If both the lists are not of same length, the above loop exits
        /// after traversing the smaller list. Now, we have to assign the
        /// rest of the nodes from the bigger list.
        currentNode.next = (list1 != null) ? list1 : list2;

        return sortedList.next;
    }
}
// @lc code=end
