package com.wolfgump.algorithm.base.tree;

/**
 * @author: ganshitao
 * @date: 2019/11/27
 * leetcode 230
 */
public class KthSmallest {
    public int kthSmallest(Tree root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count); // 1 is counted as current node
        }

        return root.key;
    }

    public int countNodes(Tree n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}
