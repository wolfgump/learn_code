package com.wolfgump.algorithm.base.tree;

import lombok.Data;

/**
 * @author: ganshitao
 * @date: 2019/11/26
 */
@Data
public class Tree {
    int key;
    Tree left, right;

    public Tree(int item) {
        key = item;
        left = right = null;
    }

    public Tree(int item, Tree left, Tree right) {
        key = item;
        this.left = left;
        this.right = right;
    }
}
