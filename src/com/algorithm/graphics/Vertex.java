package com.algorithm.graphics;

import java.util.ArrayList;

/**
 * 邻接矩阵顶点
 * 
 * @author chao
 *
 */
public class Vertex {
	public ArrayList<Edge> adjacencylist = new ArrayList<>();
	public String lable;
	public boolean visited;
	public int indegree;
	public int outdegree;

	public Vertex() {

	}

	public Vertex(String lable) {
		this.lable = lable;
	}
}
