package com.wolfgump.algorithm.base.test.linkedList;

import com.wolfgump.algorithm.AlgorithmApplicationTests;

import com.wolfgump.algorithm.base.linkedlist.ReversalWithKGroup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ganshitao
 * @date: 2019/11/6
 * To change this template use File | Settings | File and Code Templates.
 */
public class ReversalWithKGroupTest extends AlgorithmApplicationTests {
    @Autowired
    ReversalWithKGroup reversalWithKGroup;
    static ReversalWithKGroup.ListNode head = new ReversalWithKGroup.ListNode(1);

    @BeforeAll
    public static void before() {
        ReversalWithKGroup.ListNode next2 = new ReversalWithKGroup.ListNode(2);
        ReversalWithKGroup.ListNode next3 = new ReversalWithKGroup.ListNode(3);
        ReversalWithKGroup.ListNode next4 = new ReversalWithKGroup.ListNode(4);
        ReversalWithKGroup.ListNode next5 = new ReversalWithKGroup.ListNode(5);
        ReversalWithKGroup.ListNode next6 = new ReversalWithKGroup.ListNode(6);
        head.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;
        next5.next = next6;
    }

    @Test
    public void testFullLength() {
        System.out.print("start:");
        reversalWithKGroup.print(head);
        ReversalWithKGroup.ListNode newHead = reversalWithKGroup.reverseKGroup(head, 4);
        reversalWithKGroup.print(newHead);
    }
    @Test
    public void testReverseAll() {
        System.out.print("start:");
        reversalWithKGroup.print(head);
        ReversalWithKGroup.ListNode newHead = reversalWithKGroup.reverseAll(head);
        reversalWithKGroup.print(newHead);
    }
}
