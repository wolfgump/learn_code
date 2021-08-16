package com.wolfgump.algorithm.leetcode.explore.tiq.tree;

import com.wolfgump.algorithm.struct.tree.TreeNode;

/**
 * @author ShiTao.Gan
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Follow up: Could you solve it both recursively and iteratively?
 **/
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode treeNode) {
        return symmetricHelp(treeNode.getLeft(), treeNode.getRight());
    }

    private static boolean symmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.getData() != right.getData()) {
            return false;
        }
        return symmetricHelp(left.getLeft(), right.getRight()) && symmetricHelp(left.getRight(), right.getLeft());
    }
}
