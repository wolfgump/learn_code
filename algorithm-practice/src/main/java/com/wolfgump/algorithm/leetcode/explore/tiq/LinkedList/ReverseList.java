package com.wolfgump.algorithm.leetcode.explore.tiq.LinkedList;

/**
 * @author ShiTao.Gan
 * <p>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 * <p>
 * Input: head = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * <p>
 * <p>
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 **/
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode startNode = new ListNode(0, head);
        ListNode preNode = startNode;
        while (head != null) {
            ListNode temp = head.next;
            head.next = preNode;
            preNode = head;
            head = temp;
        }
        startNode.next.next = null;
        return preNode;

    }

    public static ListNode reverseList1(ListNode head) {
        ListNode startNode = new ListNode(0, head);
        ListNode preNode = startNode;
        preNode= recursiveReverse(head,preNode);
        startNode.next.next = null;
        return preNode;
    }

    private static ListNode recursiveReverse(ListNode head, ListNode preNode) {
        if (head == null) {
            return preNode;
        }
        ListNode temp = head.next;
        head.next = preNode;
        preNode = head;
        head = temp;
       return recursiveReverse(head, preNode);
    }

    private static class ListNode {
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

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        print(node1);
        ListNode newHead = reverseList1(node1);
        print(newHead);
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

}

