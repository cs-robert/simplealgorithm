package com.algorithm.graphics;

import java.util.PriorityQueue;

/**
 * 带权有向图的单源最短路径<br/>
 * Dijkstra算法-(迪杰斯特拉)算法<br/>
 * 
 * @author chao
 */
public class GrfDijkstra {
	// 为了矩阵的输出更直观好看一些，本例中约定，路径权值取值范围为：[1,10]，权值为999表示无连通
	// 并假设所有权值的和小于999
	private final int MAX = 999;
	// 顶点总数
	private int total;
	// 顶点信息
	private String[] nodes;
	// 顶点矩阵
	private int[][] matirx;
	// 源点到各顶点的距离
	private int[] dis;
	// 顶点是否已标记
	private int[] mark;

	public GrfDijkstra(int total, String[] nodes) {
		this.total = total;
		this.nodes = nodes;
		this.matirx = new int[total][total];
		this.dis = new int[total];
		this.mark = new int[total];
	}

	private void printMatrix() {
		System.out.println("--------- weighted directed matrix ---------");
		System.out.println("---0---1---2---3---4---5---6---7---8---");
		System.out.println("---A---B---C---D---E---F---G---H---I---");
		for (int i = 0; i < this.total; i++) {
			System.out.print("-" + this.nodes[i] + "|");
			for (int j = 0; j < this.total; j++) {
				System.out.print(String.format("%03d", this.matirx[i][j]) + "-");
			}
			System.out.print("\n");
		}
		System.out.println("--------- weighted directed matrix ---------");
	}

	/**
	 * Dijkstra算法-(迪杰斯特拉)算法之迭代实现
	 * 
	 * @param s
	 *            源点(起点)
	 */
	public void dijkstra(int s) {
		// 初始化
		for (int i = 0; i < this.total; i++) {
			// 初始化都未标记
			this.mark[i] = 0;
			// 给源点的直接邻接点加上初始权值
			this.dis[i] = this.matirx[s][i];
		}

		// 将源点s加入已标记
		this.mark[s] = 1;
		// 顶点到自身的距离为0
		this.dis[s] = 0;
		// 临时最短距离
		int min = -1;
		// 临时最短距离的顶点
		int k = -1;

		this.printDis(0, "屌", "初始化");

		// 除去源点s到自身的距离为0外，还要不断的进行距离修正(源点s到其它顶点(共total-1个)的最短距离)
		for (int i = 1; i < this.total; i++) {
			// 从当前最新的，源点到其它各顶点的距离信息数组dis[]中，找到一个没有标记过的，
			// 并且距离(从源点到该某顶点)最短的顶点
			min = MAX;
			for (int j = 0; j < this.total; j++) {
				if (this.mark[j] == 0 && this.dis[j] < min) {
					min = this.dis[j];
					k = j;
				}
			}

			// 标记该顶点
			this.mark[k] = 1;

			/**
			 * 距离校正<br/>
			 */
			for (int j = 0; j < this.total; j++) {
				if (this.mark[j] == 0 && (this.matirx[k][j] + this.dis[k]) < this.dis[j]) {
					this.dis[j] = this.matirx[k][j] + this.dis[k];
				}
			}

			this.printDis(i, this.nodes[k], "进行中");
		}
	}

	/**
	 * Dijkstra算法-(迪杰斯特拉)算法之优先队列实现
	 */
	public void dijkstraPQ() {
		// Item是PriorityQueue中元素，实现了Comparable接口，优先队列用此接口进行排序
		class Item implements Comparable<Item> {
			// 节点在数组的下标
			public int idx;
			// 到改节点的临时最小权值和
			public int weight;

			public Item(int idx, int weight) {
				this.idx = idx;
				this.weight = weight;
			}

			@Override
			public int compareTo(Item item) {
				if (this.weight == item.weight) {
					return 0;
				} else if (this.weight < item.weight) {
					return -1;
				} else {
					return 1;
				}
			}
		}

		// 值较小的元素总是在优先队列的头部，值较大的元素总是在优先队列的尾部
		PriorityQueue<Item> pq = new PriorityQueue<Item>();

		// 将源点(即起点)加入到优先队列
		pq.offer(new Item(0, 0));

		Item itm = null;
		while (!pq.isEmpty()) {
			itm = pq.poll();

			// 图中某节点下标
			int idx = itm.idx;
			// 到某节点的临时最小权值和
			int weight = itm.weight;

			// 如果该元素还未标记，则更新最小权值各
			if (this.mark[idx] == 0) {
				this.dis[idx] = weight;
				this.mark[idx] = 1;
			}

			// 找出该元素(假设A)的所有未标记的邻接点(假设B)
			// 则，源点到B的距离可表示为：(源点到A的距离) + (A到B的距离)
			// 将源点到B的距离加入到优先队列中
			for (int i = 0; i < this.total; i++) {
				if (this.mark[i] == 0) {
					pq.offer(new Item(i, this.dis[idx] + this.matirx[idx][i]));
				}
			}
		}
	}

	private void printDis(int i, String node, String pre) {
		System.out.print("\n" + pre + "," + node + "," + i + "--->");
		for (int t = 0; t < this.dis.length; t++) {
			System.out.print(t + ",");
		}
		System.out.print("\n" + pre + i + "--->");
		for (int t : this.dis) {
			System.out.print(t + ",");
		}
		System.out.print("\n");
	}

	// 初始化图数据
	// 0---1---2---3---4---5---6---7---8---
	// A---B---C---D---E---F---G---H---I---
	private void initGrf() {
		// 初始化矩阵为最大值(各节点都不连通)
		for (int i = 0; i < this.total; i++) {
			for (int j = 0; j < this.total; j++) {
				if (i == j) {
					this.matirx[i][j] = 0;
				} else {
					this.matirx[i][j] = MAX;
				}
			}
		}

		// 手动设置有向路径
		// A->B, A->E, A->D
		this.matirx[0][1] = 2;
		this.matirx[0][4] = 3;
		this.matirx[0][3] = 1;
		// B->C
		this.matirx[1][2] = 2;
		// C->F
		this.matirx[2][5] = 1;
		// D->E, D->G
		this.matirx[3][4] = 5;
		this.matirx[3][6] = 2;
		// E->F, E->H
		this.matirx[4][5] = 6;
		this.matirx[4][7] = 1;
		// F->I
		this.matirx[5][8] = 3;
		// G->H
		this.matirx[6][7] = 4;
		// H->F, H->I
		this.matirx[7][5] = 1;
		this.matirx[7][8] = 2;
	}

	public static void main(String[] args) {
		String[] nodes = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
		GrfDijkstra grf = new GrfDijkstra(nodes.length, nodes);
		grf.initGrf();
		grf.printMatrix();

		System.out.println();
		System.out.println("------ Dijkstra算法-(迪杰斯特拉)算法之迭代开始 ------");
		grf.dijkstra(0);
		grf.printDis(0, "屌", "最终值");
		System.out.print("\n");
		System.out.println("------ Dijkstra算法-(迪杰斯特拉)算法之迭代结束 ------");

		System.out.println();
		System.out.println("------ Dijkstra算法-(迪杰斯特拉)算法之优先队列开始 ------");
		grf.dijkstraPQ();
		grf.printDis(0, "屌", "最终值");
		System.out.print("\n");
		System.out.println("------ Dijkstra算法-(迪杰斯特拉)算法之优先队列结束 ------");
	}
}