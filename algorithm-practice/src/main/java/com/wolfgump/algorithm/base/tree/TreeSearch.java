package com.wolfgump.algorithm.base.tree;

import org.springframework.stereotype.Component;

/**
 * @author: ganshitao
 * @date: 2019/11/26
 */
@Component
public class TreeSearch {
    /**
     * 前序遍历 根》左》右
     */
    public void printPreSearch(Tree tree) {
        if (tree == null) {
            return;
        }
        System.out.println(tree.getKey());
        printPreSearch(tree.getLeft());
        printPreSearch(tree.getRight());
    }

    /**
     * 中序遍历 左》根》右
     */
    public void printInSearch(Tree tree) {
        if (tree == null) {
            return;
        }
        printInSearch(tree.getLeft());
        System.out.println(tree.getKey());
        printInSearch(tree.getRight());
    }

    /**
     * 后序遍历 左》右》根
     */
    public void printPostSearch(Tree tree) {
        if (tree == null) {
            return;
        }
        printPostSearch(tree.getLeft());
        printPostSearch(tree.getRight());
        System.out.println(tree.getKey());

    }
}
