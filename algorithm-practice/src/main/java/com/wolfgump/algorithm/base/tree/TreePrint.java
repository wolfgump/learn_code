package com.wolfgump.algorithm.base.tree;

import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: ganshitao
 * @date: 2019/11/26
 */
@Component
public class TreePrint {
    /**
     * 前序遍历 根》左》右
     */
    public static void printPre(Tree tree) {
        if (tree == null) {
            return;
        }
        System.out.println(tree.getKey());
        printPre(tree.getLeft());
        printPre(tree.getRight());
    }

    /**
     * 中序遍历 左》根》右
     */
    public static void printIn(Tree tree) {
        if (tree == null) {
            return;
        }
        printIn(tree.getLeft());
        System.out.println(tree.getKey());
        printIn(tree.getRight());
    }

    /**
     * 后序遍历 左》右》根
     */
    public static void printPost(Tree tree) {
        if (tree == null) {
            return;
        }
        printPost(tree.getLeft());
        printPost(tree.getRight());
        System.out.println(tree.getKey());
    }

    /**
     * 广度优先 使用队列
     *
     * @param tree
     */
    public static void printBFS(Tree tree) {
        Queue<Tree> queue = new LinkedBlockingQueue<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            Tree current = queue.poll();
            System.out.println(current.key);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    /**
     * 深度优先 使用栈
     *
     * @param tree
     */
    public static void printDFS(Tree tree) {
        Stack<Tree> stack = new Stack<>();
        stack.push(tree);
        while (!stack.empty()) {
            Tree current = stack.pop();
            System.out.println(current.key);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
    }

    public static void main(String[] args) {
        Tree tree1 = new Tree(1);
        Tree tree2 = new Tree(2);
        Tree tree3 = new Tree(3);
        Tree tree4 = new Tree(4);
        Tree tree5 = new Tree(5);
        Tree tree6 = new Tree(6);
        Tree tree7 = new Tree(7);

        tree1.left = tree2;
        tree1.right = tree3;
        tree2.left = tree4;
        tree2.right = tree5;
        tree3.left = tree6;
        tree3.right = tree7;
        printPre(tree1);
        System.out.println("pre=============end");
        printIn(tree1);
        System.out.println("in=============end");
        printPost(tree1);
        System.out.println("post=============end");
        printBFS(tree1);
        System.out.println("bsf=============end");
        printDFS(tree1);
        System.out.println("dsf=============end");
    }

}
