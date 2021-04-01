package com.wolfgump.algorithm.struct.test.tree;

import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.struct.tree.AbstractTree;
import com.wolfgump.algorithm.struct.tree.TreeNode;
import org.junit.jupiter.api.Test;

public class TreeTest extends AlgorithmApplicationTests {
	@Test
	public void testPreOrder() {
		TreeNode treeNode = build();
		AbstractTree.preOrder(treeNode);
	}

	@Test
	public void testInOrder() {
		TreeNode treeNode = build();
		AbstractTree.inOrder(treeNode);
	}

	@Test
	public void testPostOrder() {
		TreeNode treeNode = build();
		AbstractTree.postOrder(treeNode);
	}

	@Test
	public void testFromPreInOrder() {
		int[] preArray = { 1, 2, 4,5,3 };
		int[] inArray = { 4,2,5,1,3 };
		TreeNode root=AbstractTree.fromPreInOrderArray(preArray, inArray);
		AbstractTree.preOrder(root);
	}
	@Test
	public void testDepthFistSearch() {
		TreeNode treeNode = build();
		AbstractTree.depthFirstSearch(treeNode);
	}
	@Test
	public void testBreadthFistSearch() {
		TreeNode treeNode = build();
		AbstractTree.breathFirstSearch(treeNode);
	}

	private TreeNode build() {
		TreeNode treeNode = new TreeNode(1);
		TreeNode treeNodeLeft = new TreeNode(2);
		TreeNode treeNodeRight = new TreeNode(3);
		TreeNode treeNodeLeft2 = new TreeNode(4);
		TreeNode treeNodeRight2 = new TreeNode(5);
		treeNode.setLeft(treeNodeLeft);
		treeNode.setRight(treeNodeRight);
		treeNodeLeft.setLeft(treeNodeLeft2);
		treeNodeLeft.setRight(treeNodeRight2);
		return treeNode;
	}
}
