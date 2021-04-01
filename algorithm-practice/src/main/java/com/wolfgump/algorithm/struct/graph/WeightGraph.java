package com.wolfgump.algorithm.struct.graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 带权重的图
 */
public class WeightGraph {

	private LinkedList<Edge> adj[]; // 邻接表

	private int v; // 顶点个数

	public WeightGraph(int v) {
		this.v = v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			this.adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int s, int t, int w) { // 添加一条边
		this.adj[s].add(new Edge(s, t, w));
	}

	private class Edge {
		public int sid; // 边的起始顶点编号

		public int tid; // 边的终止顶点编号

		public int w; // 权重

		public Edge(int sid, int tid, int w) {
			this.sid = sid;
			this.tid = tid;
			this.w = w;
		}
	}

	// 下面这个类是为了dijkstra实现用的
	private class Vertex {
		public int id; // 顶点编号ID

		public int dist; // 从起始顶点到这个顶点的距离

		public Vertex(int id, int dist) {
			this.id = id;
			this.dist = dist;
		}
	}

	public void dijkstra(int s, int t) {
		int[] predecessor = new int[this.v]; // 用来还原最短路径
		Vertex[] vertexes = new Vertex[this.v];
		for (int i = 0; i < this.v; ++i) {
			vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
		}
		PriorityQueue<Vertex> queue = new PriorityQueue(this.v, new Comparator<Vertex>() {
			@Override
			public int compare(Vertex v1, Vertex v2) {
				return v1.dist - v2.dist;
			}
		});// 小顶堆
		boolean[] inqueue = new boolean[this.v]; // 标记是否进入过队列
		vertexes[s].dist = 0;
		queue.add(vertexes[s]);
		inqueue[s] = true;
		while (!queue.isEmpty()) {
			Vertex minVertex = queue.poll();
			if (minVertex.id == t) break;
			for (int i = 0; i < adj[minVertex.id].size(); i++) {
				Edge e = adj[minVertex.id].get(i);
				Vertex nextVertex = vertexes[e.tid];
				if (minVertex.dist + e.w < nextVertex.dist) {
					predecessor[nextVertex.id] = minVertex.id;
					if (inqueue[nextVertex.id] == true) {
						queue.remove(nextVertex);
						nextVertex.dist = minVertex.dist + e.w;
						queue.offer(nextVertex);
					}
					else {
						nextVertex.dist = minVertex.dist + e.w;
						queue.offer(nextVertex);
						inqueue[nextVertex.id] = true;
					}
				}
			}
		}
		// 输出最短路径
		System.out.print(s);
		print(s, t, predecessor);
	}

	private void print(int s, int t, int[] predecessor) {
		if (s == t) return;
		print(s, predecessor[t], predecessor);
		System.out.print("->" + t);
	}
}
