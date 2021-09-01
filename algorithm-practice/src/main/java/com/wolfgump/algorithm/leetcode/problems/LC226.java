package com.wolfgump.algorithm.leetcode.problems;

import com.wolfgump.algorithm.struct.tree.TreeNode;

/**
 * @author ShiTao.Gan
 * 翻转一棵二叉树。
 **/
public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp=root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        invertTree(root.getLeft());
        invertTree(root.getRight());
        return root;
    }

}
