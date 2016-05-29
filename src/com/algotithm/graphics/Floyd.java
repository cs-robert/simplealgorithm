package com.algotithm.graphics;

/**
 * Floyd算法求所有点对之间的最短路径 原理：主要是通过遍历的方式任何一对顶点之间vi和vj的最短路径都都只能存在1到n-1的节点，所以可以通过遍历
 * 这些节点的方式获得他们的最短路径 其中p是保存每一个最短路径vi到vj中紧跟vi之后的路径中第一个节点，所以可以通过遍历(vi,p[vi][vj]),
 * (p[vi][vj],vx)...这样一直遍历下去，直到p中的值等于vj为止，就会找到从vi到vj的一个完整的最短路径。
 * 
 * @author chao
 *
 */
public class Floyd {

	public static void shortestPath_FLOYD(int[][] graph, int n) {
		int[][] D = new int[n][n];// 保存从i到j的最小路径值
		int[][] p = new int[n][n];// 保存经过的中间节点
		for (int i = 0; i < n; i++) {// 初始化D，p
			for (int j = 0; j < n; j++) {
				if (graph[i][j] < Integer.MAX_VALUE) {

					p[i][j] = j;
				} else {
					p[i][j] = -1;
				}
				D[i][j] = graph[i][j];
			}
		}

		for (int x = 0; x < n; x++) {// 进行Floyd算法，从0到n-1所有可能进行遍历
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (D[i][j] > D[i][x] + D[x][j]) {
						D[i][j] = D[i][x] + D[x][j];
						p[i][j] = p[i][x];
					}
				}
			}
		}
		// 下面对获得的结果进行展示
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" " + D[i][j]);
			}
			System.out.println();
		}
		System.out.println("++++++++++++++++++++++++++++++++++++");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" " + p[i][j]);
			}
			System.out.println();
		}
		System.out.println("+++++++++++++++++++++++++++++++++++");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("输出i=" + i + "到j=" + j + "最短路径：");
				int k = p[i][j];
				if (k == -1) {
					System.out.println("没有最短路径");
				} else {
					System.out.print(" " + k);
					while (k != j) {
						k = p[k][j];
						System.out.print(" " + k);
					}
					// System.out.println(" "+k);
					System.out.println();
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 4, 11 }, { 6, 0, 2 }, { 3, Integer.MAX_VALUE, 0 } };
		Floyd.shortestPath_FLOYD(graph, 3);
	}

}
