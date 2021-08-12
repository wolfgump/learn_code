package com.wolfgump.algorithm.base.recursion;

/**
 * @author ShiTao.Gan
 **/
public class BinaryTreeNode {
    private Integer value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void add(Integer value) {
        if (value <= this.value) {
            if (this.left == null) {
                this.left = new BinaryTreeNode(value);
            } else {
                this.left.add(value);
            }
        } else {
            if (this.right == null) {
                this.right = new BinaryTreeNode(value);
            } else {
                this.right.add(value);
            }
        }
    }

    public void print() {
        recursePrint(this);
    }

    private void recursePrint(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        recursePrint(binaryTreeNode.left);
        System.out.println(binaryTreeNode.value);
        recursePrint(binaryTreeNode.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(10);
        binaryTreeNode.add(9);
        binaryTreeNode.add(8);
        binaryTreeNode.add(7);
        binaryTreeNode.add(11);
        binaryTreeNode.add(12);
        binaryTreeNode.add(13);

        binaryTreeNode.print();
    }
}
