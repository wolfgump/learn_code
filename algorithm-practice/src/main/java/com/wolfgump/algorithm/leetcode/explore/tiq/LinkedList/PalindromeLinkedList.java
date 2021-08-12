package com.wolfgump.algorithm.leetcode.explore.tiq.LinkedList;

import java.util.Stack;

/**
 * @author ShiTao.Gan
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 * <p>
 * <p>
 * Follow up: Could you do it in O(n) time and O(1) space?
 **/
public class PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 空间 O(n/2) 时间O(n)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        ListNode fast = head, slow = head;
        Stack<Integer> stack = new Stack<>();
        stack.push(head.val);
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow.val);
        }
        while (fast.next != null) {
            Integer cur = stack.pop();
            if (cur != fast.val) {
                return false;
            }
            fast = fast.next;
        }
        return true;
    }

    /**
     * 空间 O(1) 时间O(n)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = null;
        ListNode beforeHalf = reverseList(head);
        while (fast.next != null && beforeHalf.next != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            beforeHalf = beforeHalf.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        boolean result = isPalindrome2(node1);
        System.out.println(result);
    }
}
