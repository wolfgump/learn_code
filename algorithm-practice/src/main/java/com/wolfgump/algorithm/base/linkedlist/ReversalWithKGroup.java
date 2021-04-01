package com.wolfgump.algorithm.base.linkedlist;


import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ganshitao
 * @date: 2019/11/4
 * To change this template use File | Settings | File and Code Templates.
 */
@Component
public class ReversalWithKGroup {
    /**
     * 给定这个链表：1->2->3->4->5
     * <p>
     * 当 k=2 时，应当返回：2->1->4->3->5
     * <p>
     * 当 k=3 时，应当返回：3->2->1->4->5
     */


    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode current = head;
        ListNode next;
        int n = k;
        while (current != null && n-- > 0) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        ListNode newHead = reverseKGroup(current, k);
        head.next = newHead;
        return pre;
    }
    public ListNode reverseAll(ListNode head) {
        if ( head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
            if (head == null) {
                System.out.println("null");
            }
        }
    }

    public static class ListNode {
        int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

}

