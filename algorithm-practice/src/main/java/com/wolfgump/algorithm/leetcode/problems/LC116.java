package com.wolfgump.algorithm.leetcode.problems;

/**
 * @author ShiTao.Gan
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点.
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有next 指针都被设置为 NULL。
 **/
public class LC116 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        connectTwoNode(root.left, root.right);
        return null;
    }

    public void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        connectTwoNode(node1.right, node2.left);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
