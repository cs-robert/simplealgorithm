package com.algorithm.graphics;

/**
 * 邻接矩阵边
 * 
 * @author chao
 *
 */
public class Edge {
	public Vertex from;
	public Vertex to;
	public int weight;
	public boolean visited;

	public Edge(Vertex from, Vertex to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public Edge() {

	}
}
