package com.wolfgump.algorithm.leetcode.explore.tiq.tree;

import com.wolfgump.algorithm.struct.tree.TreeNode;

/**
 * @author ShiTao.Gan
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 **/
public class ValidateBST {
    public static boolean isValidBST(TreeNode root) {
        return validBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static boolean validBST(TreeNode root, int minVal, int maxVal) {
        if (root == null) return true;
        if (root.getData() >= maxVal || root.getData() <= minVal) return false;
        return validBST(root.getLeft(), minVal, root.getData()) && validBST(root.getRight(), root.getData(), maxVal);
    }

    private static void inPrint(TreeNode root) {
        if(root==null) return;
        inPrint(root.getLeft());
        System.out.println(root.getData());
        inPrint(root.getRight());
    }

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.setLeft(treeNode1);
        treeNode2.setRight(treeNode3);
        inPrint(treeNode2);
        boolean result = isValidBST(treeNode2);
        System.out.println(result);
    }

}
