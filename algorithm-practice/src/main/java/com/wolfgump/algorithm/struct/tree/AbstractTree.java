package com.wolfgump.algorithm.struct.tree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AbstractTree {
	public static void preOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		System.out.println(treeNode.getData());
		preOrder(treeNode.getLeft());
		preOrder(treeNode.getRight());
	}

	public static void inOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		inOrder(treeNode.getLeft());
		System.out.println(treeNode.getData());
		inOrder(treeNode.getRight());
	}

	public static void postOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		postOrder(treeNode.getLeft());
		postOrder(treeNode.getRight());
		System.out.println(treeNode.getData());
	}

	public static TreeNode fromPreInOrderArray(int[] preArray, int[] inArray) {
		if (preArray == null || preArray.length < 1 || inArray == null || inArray.length < 1) {
			return new TreeNode(-1);
		}
		if (preArray.length != inArray.length) {
			return new TreeNode(-1);
		}
		if (preArray.length == 1) {
			return new TreeNode(preArray[0]);
		}
		//构造根节点
		TreeNode root = new TreeNode(preArray[0]);
		int indexOfRoot = -1;
		for (int i = 0; i < inArray.length; i++) {
			if (inArray[i] == preArray[0]) {
				indexOfRoot = i;
				break;
			}
		}
		//构建左子树
		//需要左子树的前序队列和中序队列
		int lChildLength = indexOfRoot;
		int[] lPreArray = new int[lChildLength];
		System.arraycopy(preArray, 1, lPreArray, 0, lChildLength);
		int[] lInArray = new int[indexOfRoot];
		System.arraycopy(inArray, 0, lInArray, 0, lChildLength);
		root.setLeft(fromPreInOrderArray(lPreArray, lInArray));

		//构建右子树
		//需要左子树的前序队列和中序队列
		int rChildLength = inArray.length - 1 - indexOfRoot;
		int[] rPreArray = new int[rChildLength];
		System.arraycopy(preArray, indexOfRoot + 1, rPreArray, 0, rChildLength);
		int[] rInArray = new int[rChildLength];
		System.arraycopy(inArray, indexOfRoot + 1, rInArray, 0, rChildLength);
		root.setRight(fromPreInOrderArray(rPreArray, rInArray));
		return root;
	}

	public static void depthFirstSearch(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			System.out.println(node.getData());
			if (node.getRight() != null) {
				stack.push(node.getRight());
			}
			if (node.getLeft() != null) {
				stack.push(node.getLeft());
			}

		}
	}

	public static void breathFirstSearch(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println(node.getData());
			if (node.getLeft() != null) {
				queue.offer(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.offer(node.getRight());
			}
		}
	}

}
