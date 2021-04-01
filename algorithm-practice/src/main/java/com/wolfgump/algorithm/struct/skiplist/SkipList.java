package com.wolfgump.algorithm.struct.skiplist;

import java.util.Random;

/**
 * 链表的基础上加索引
 */
public class SkipList {
	private static final int MAX_LEVEL = 16;

	private int levelCount = 1;

	/**
	 * 带头链表
	 */
	private Node head = new Node(MAX_LEVEL);

	private Random r = new Random();

	public void insert(int val) {
		int level = head.forwards[0] == null ? 1 : randomLevel();
		if (level > levelCount) {
			level = levelCount + 1;
		}
		Node newNode = new Node(level);
		newNode.data = val;
		Node[] update = new Node[level];

		//初始化
		for (int i = 0; i < level; i++) {
			update[i] = head;
		}
		//查找NewNode应该在每层插入的位置
		Node p = head;
		for (int i = level - 1; i >= 0; i--) {
			while (p.forwards[i] != null && p.forwards[i].data < val) {
				p = p.forwards[i];
			}
			update[i] = p;
		}
		for (int i = 0; i < level; i++) {
			newNode.forwards[i] = update[i].forwards[i];
			update[i].forwards[i] = newNode;
		}
	}

	public void delete(int value) {
		Node[] update = new Node[levelCount];
		Node p = head;
		for (int i = levelCount - 1; i >= 0; --i) {
			while (p.forwards[i] != null && p.forwards[i].data < value) {
				p = p.forwards[i];
			}
			update[i] = p;
		}

		if (p.forwards[0] != null && p.forwards[0].data == value) {
			for (int i = levelCount - 1; i >= 0; --i) {
				if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
					update[i].forwards[i] = update[i].forwards[i].forwards[i];
				}
			}
		}
	}

	public Node find(int value) {
		Node p = head;
		// 从最大层开始查找，找到前一节点，通过--i，移动到下层再开始查找
		for (int i = levelCount - 1; i >= 0; --i) {
			while (p.forwards[i] != null && p.forwards[i].data < value) {
				// 找到前一节点
				p = p.forwards[i];
			}
		}

		if (p.forwards[0] != null && p.forwards[0].data == value) {
			return p.forwards[0];
		}
		else {
			return null;
		}
	}

	private int randomLevel() {
		int level = 1;
		for (int i = 1; i < MAX_LEVEL; ++i) {
			if (r.nextInt() % 2 == 1) {
				level++;
			}
		}
		return level;
	}

	/**
	 * 打印所有数据
	 */
	public void printAll_beautiful() {
		Node p = head;
		Node[] c = p.forwards;
		Node[] d = c;
		int maxLevel = c.length;
		for (int i = maxLevel - 1; i >= 0; i--) {
			do {
				System.out.print((d[i] != null ? d[i].data : null) + ":" + i + "-------");
			} while (d[i] != null && (d = d[i].forwards)[i] != null);
			System.out.println();
			d = c;
		}
	}

	/**
	 * 跳表的节点，每个节点记录了当前节点数据和所在层数数据
	 */
	public class Node {
		private int data = -1;

		/**
		 * 表示当前节点位置的下一个节点所有层的数据，从上层切换到下层，就是数组下标-1，
		 * forwards[3]表示当前节点在第三层的下一个节点。
		 */
		private Node[] forwards;

		/**
		 * 这个值其实可以不用，看优化insert()
		 */
		private int maxLevel = 0;

		public Node(int level) {
			forwards = new Node[level];
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("{ data: ");
			builder.append(data);
			builder.append("; levels: ");
			builder.append(maxLevel);
			builder.append(" }");
			return builder.toString();
		}
	}
}
