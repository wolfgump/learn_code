package com.wolfgump.algorithm.leetcode.explore.tiq.tree;

import com.wolfgump.algorithm.struct.tree.TreeNode;

/**
 * @author ShiTao.Gan
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * <p>
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 **/
public class SortArrayToBinaryTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return null;
    }

    public static TreeNode helper(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        // (high+low)/2 可能会因为high+low超过整数最大值而溢出
        int mid = low + (high - low) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.setLeft(helper(nums, low, mid - 1));
        treeNode.setRight(helper(nums, mid + 1, high));
        return treeNode;
    }
}