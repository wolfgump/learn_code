package com.wolfgump.algorithm.struct.test.graph;

import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.struct.graph.Graph;
import com.wolfgump.algorithm.struct.graph.WeightGraph;
import org.junit.jupiter.api.Test;

public class GraphTest extends AlgorithmApplicationTests {
	@Test
	public void testBFS() {
		Graph graph = new Graph(8);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(2, 5);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 1);
		graph.bfs(0, 7);
		System.out.println("===============");
		graph.bfs(0,7);
	}
	@Test
	public void testToTopKahn() {
		Graph graph = new Graph(8);
		graph.addEdgeArrow(0, 1);
		graph.addEdgeArrow(0, 3);
		graph.addEdgeArrow(1, 2);
		graph.addEdgeArrow(1, 4);
		graph.addEdgeArrow(2, 5);
		graph.addEdgeArrow(4, 5);
		graph.addEdgeArrow(4, 6);
		graph.addEdgeArrow(5, 7);
		graph.toTopSortKahn();
		System.out.println("===============");
	}
	@Test
	public void testToTopDFS() {
		Graph graph = new Graph(8);
		graph.addEdgeArrow(0, 1);
		graph.addEdgeArrow(0, 3);
		graph.addEdgeArrow(1, 2);
		graph.addEdgeArrow(1, 4);
		graph.addEdgeArrow(2, 5);
		graph.addEdgeArrow(4, 5);
		graph.addEdgeArrow(4, 6);
		graph.addEdgeArrow(5, 7);
		graph.toTopSortDfs();
		System.out.println("===============");
	}
	@Test
	public void testWightGraph(){
		WeightGraph weightGraph=new WeightGraph(8);
		weightGraph.addEdge(0, 1,1);
		weightGraph.addEdge(0, 3,7);
		weightGraph.addEdge(1, 2,4);
		weightGraph.addEdge(1, 4,3);
		weightGraph.addEdge(3, 7,4);
		weightGraph.addEdge(2, 5,1);
		weightGraph.addEdge(4, 5,5);
		weightGraph.addEdge(4, 6,2);
		weightGraph.addEdge(5, 7,2);
		weightGraph.addEdge(6, 7,3);
		weightGraph.dijkstra(0,7);
	}
}
