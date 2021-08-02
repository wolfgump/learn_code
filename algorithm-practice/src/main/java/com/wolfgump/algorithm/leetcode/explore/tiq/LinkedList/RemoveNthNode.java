package com.wolfgump.algorithm.leetcode.explore.tiq.LinkedList;

/**
 * @author ShiTao.Gan
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * Follow up: Could you do this in one pass?
 **/
public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start;
        ListNode fast = start;
        start.next = head;
        // make sure faster fast n than slow
        for (int i = 0; i < n + 1; i++) {
            fast.next = fast.next.next;
        }
        while (fast.next != null) {
            fast.next = fast.next.next;
            slow.next = slow.next.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
