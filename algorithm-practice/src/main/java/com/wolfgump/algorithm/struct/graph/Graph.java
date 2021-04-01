package com.wolfgump.algorithm.struct.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	//定点的个数
	private int v;

	private LinkedList<Integer>[] adj;

	public Graph(int v) {
		this.v = v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int s, int t) {
		adj[s].add(t);
		adj[t].add(s);
	}

	//有向图
	public void addEdgeArrow(int s, int t) {
		adj[s].add(t);
	}

	public void bfs(int s, int t) {
		if (t == s) return;
		//节点是否被访问过
		boolean[] visited = new boolean[v];
		visited[s] = true;
		//到达这个节点的前一个节点
		int[] prev = new int[v];
		for (int i = 0; i < prev.length; i++) {
			prev[i] = -1;
		}
		//访问节点的队列
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(s);
		while (!queue.isEmpty()) {
			int w = queue.poll();
			for (int i = 0; i < adj[w].size(); i++) {
				int q = adj[w].get(i);
				if (!visited[q]) {
					prev[q] = w;
					if (q == t) {
						print(prev, s, t);
						return;
					}
					visited[q] = true;
					queue.offer(q);
				}
			}
		}

	}

	boolean found = false; // 全局变量或者类成员变量

	public void dfs(int s, int t) {

		if (t == s) return;
		//节点是否被访问过
		boolean[] visited = new boolean[v];
		visited[s] = true;
		//到达这个节点的前一个节点
		int[] prev = new int[v];
		for (int i = 0; i < prev.length; i++) {
			prev[i] = -1;
		}
		recurDfs(s, t, visited, prev);
		print(prev, s, t);
	}

	private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
		if (found) {
			return;
		}
		visited[w] = true;
		for (int i = 0; i < adj[w].size(); i++) {
			int q = adj[w].get(i);
			if (!visited[w]) {
				if (q == t) {
					found = true;
					return;
				}
			}
			prev[q] = w;
			recurDfs(q, t, visited, prev);
		}
	}

	/**
	 * 拓扑排序
	 * Kahn 算法
	 * 先打印入度为零的顶点，然后删除，其指向的顶点入度减一
	 */
	public void toTopSortKahn() {
		int[] inDegree = new int[v];
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				int w = adj[i].get(j);
				inDegree[w]++;
			}
		}
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			int i = queue.remove();
			System.out.print(i + "->");
			for (int j = 0; j < adj[i].size(); j++) {
				int k = adj[i].get(j);
				inDegree[k]--;
				if (inDegree[k] == 0) {
					queue.add(k);
				}
			}
		}

	}

	/**
	 * 拓扑排序 深度优先
	 * 1.把邻接表转成逆邻接表
	 * 2.深度遍历 打印完依赖节点在打印根节点
	 */
	public void toTopSortDfs() {
		LinkedList<Integer>[] inverseAdj = new LinkedList[v];
		//初始化
		for (int i = 0; i < v; i++) {
			inverseAdj[i] = new LinkedList<>();
		}
		//邻接表转成逆邻接表
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				int w = adj[i].get(j);
				adj[w].add(i);
			}
		}
		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				toTopSortDfsRecursion(i, inverseAdj, visited);
			}
		}
	}

	private void toTopSortDfsRecursion(int vertex, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
		for (int i = 0; i < inverseAdj[vertex].size(); i++) {
			int w = inverseAdj[vertex].get(i);
			if (!visited[w]) {
				visited[w] = true;
				toTopSortDfsRecursion(w, inverseAdj, visited);
			}
		}
		System.out.println(vertex + "->");
	}

	private void print(int[] pre, int s, int t) {
		if (pre[t] != -1 && t != s) {
			print(pre, s, pre[t]);
		}
		System.out.println(t + "->");
	}
}
