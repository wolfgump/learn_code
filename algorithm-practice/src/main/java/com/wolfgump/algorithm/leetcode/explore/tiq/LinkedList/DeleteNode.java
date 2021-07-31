package com.wolfgump.algorithm.leetcode.explore.tiq.LinkedList;


import java.util.LinkedList;

/**
 * @author ShiTao.Gan
 * Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.
 * <p>
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * Example 2:
 * <p>
 * <p>
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 * Example 3:
 * <p>
 * Input: head = [1,2,3,4], node = 3
 * Output: [1,2,4]
 * Example 4:
 * <p>
 * Input: head = [0,1], node = 0
 * Output: [1]
 * Example 5:
 * <p>
 * Input: head = [-3,5,-99], node = -3
 * Output: [5,-99]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of the nodes in the given list is in the range [2, 1000].
 * -1000 <= Node.val <= 1000
 * The value of each node in the list is unique.
 * The node to be deleted is in the list and is not a tail node
 **/
public class DeleteNode {
    public void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
