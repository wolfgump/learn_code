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
    public ListNode reverseAll(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = reverseAll(head.next);
        newHead.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 给定这个链表：1->2->3->4->5
     * <p>
     * 当 k=2 时，应当返回：2->1->4->3->5
     * <p>
     * 当 k=3 时，应当返回：3->2->1->4->5
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode b = null;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                //不翻转
                return head;
            }
            b = head.next;
        }
        ListNode cur = reverse(head, b);
        cur.next = reverseKGroup(cur, k);
        return null;

    }

    private ListNode reverse(ListNode a, ListNode b) {
        if (a == null) {
            return null;
        }
        ListNode cur = a, next = a, pre = null;
        while (cur != b) {
            pre = cur;
            cur = next;
            next = cur.next;
            cur.next = pre;
        }
        return cur;
    }

    ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, n - 1);
        newHead.next.next = head;
        //与reverseAll不同，head.next要和剩余的链表连起来
        head.next = successor;
        return newHead;
    }

    public ListNode reverseMn(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseMn(head, m - 1, n - 1);
        return head;
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

