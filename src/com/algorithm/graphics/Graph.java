package com.algorithm.graphics;

import java.util.Hashtable;
import java.util.Queue;

import com.algorithm.list.LinkedQueue;

/**
 * 邻接表
 * 
 * @author chao
 *
 */
public class Graph {
	private Hashtable<String, Vertex> ver_List;

	/* Graph构造 */
	public Graph() {
		ver_List = new Hashtable<>();
	}

	/* 添加节点 */
	public void addVertex(Vertex v) {
		ver_List.put(v.lable, v);
	}

	/* 添加边 */
	public void addEdge(Vertex from, Vertex to, int weight) {
		Edge edge = new Edge(from, to, weight);
		from.outdegree++;
		to.indegree++;
		from.adjacencylist.add(edge);
	}

	/* 添加边 */
	public void addEdge(String from, String to, int weight) {
		Vertex fromvertex = ver_List.get(from);
		Vertex toVertex = ver_List.get(to);
		if (from == null || to == null) {
			throw new RuntimeException();
		}
		Edge edge = new Edge(fromvertex, toVertex, weight);
		fromvertex.outdegree++;
		toVertex.indegree++;
		fromvertex.adjacencylist.add(edge);
	}

	public void topSort() {
		LinkedQueue<Vertex> queue = new LinkedQueue<Vertex>();
		int counter = 0;
		for (Vertex vertex : ver_List.values()) {
			if (vertex.indegree == 0) {
				queue.enqueue(vertex);
			}
		}
		while (!queue.isEmpty()) {
			Vertex vertex = queue.dequeue();
			System.out.println(vertex.lable);
			counter++;
			for (Edge edge : vertex.adjacencylist) {
				if (--edge.to.indegree == 0) {
					queue.enqueue(edge.to);
				}
			}
		}
		if (counter != ver_List.size()) {
			System.out.println("有回路");
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex(new Vertex("A"));
		graph.addVertex(new Vertex("B"));
		graph.addVertex(new Vertex("C"));
		graph.addVertex(new Vertex("D"));
		graph.addEdge("A", "D", 0);
		graph.addEdge("A", "C", 0);
		graph.addEdge("D", "B", 0);
		graph.addEdge("C", "B", 0);
		graph.topSort();
	}
}
