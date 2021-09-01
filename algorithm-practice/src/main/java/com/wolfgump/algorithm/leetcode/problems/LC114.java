package com.wolfgump.algorithm.leetcode.problems;

import com.wolfgump.algorithm.struct.tree.TreeNode;

/**
 * @author ShiTao.Gan
 * 二叉树展开为单链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 1.展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 2.展开后的单链表应该与二叉树 先序遍历 顺序相同。
 **/
public class LC114 {
    public void flatten(TreeNode root) {
        flatten(root.getLeft());
        flatten(root.getRight());
        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();

        root.setLeft(null);
        root.setRight(left);
        TreeNode p = root;
        while (p.getRight() != null) {
            p = p.getRight();
        }
        p.setRight(right);
    }
}
