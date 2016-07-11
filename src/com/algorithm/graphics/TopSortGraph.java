package com.algorithm.graphics;

import java.util.Stack;
import java.util.Vector;

/**
 * 拓扑排序
 * 
 * @author chao
 *
 */

public class TopSortGraph {

	int vertexNum;
	Vector[] vector;
	Stack stack;
	int[] result;
	int[] in;// 入度

	/**
	 * 
	 * 构造一个图
	 * 
	 * @param num
	 *            图的顶点数
	 * 
	 */
	public TopSortGraph(int num) {

		vertexNum = num;
		vector = new Vector[vertexNum];
		stack = new Stack();
		result = new int[vertexNum];
		in = new int[vertexNum];

	}

	/**
	 * 向图中添加无向边
	 * 
	 * @param I
	 *            边的一个顶点
	 * @param J
	 *            边的另一个顶点
	 * @return 是否添加成功
	 */
	public boolean addEdge(int I, int J) {

		/**
		 * 判断用户输入的是否是一个顶点，如果是，则返回flase,添加不成功
		 */
		if (J == I) {
			return false;
		}

		/**
		 * 判断所输入的顶点值是否在图所顶点范围值内，如果不在，则提示顶点不存在
		 * 
		 */
		if (I < vertexNum && J < vertexNum && I >= 0 && J >= 0) {

			/**
			 * 
			 * 判断边是否存在
			 */

			if (isEdgeExists(I, J)) {

				return false;
			}

			/**
			 * 添加边，将孤头的入度加1
			 */

			vector[I].add(J);
			in[J]++;
			return true;
		}
		return false;
	}

	/**
	 * 判断有向边是否存在
	 * 
	 * @param i
	 *            要查询的有向边的一个孤尾
	 * @param j
	 *            要查询的有向边的另一个孤头
	 * @return 边是否存在，false:不存在，true:存在
	 */

	public boolean isEdgeExists(int i, int j) {

		/**
		 * 判断所输入的顶点值是否在图所顶点范围值内，如果不在，则提示顶点不存在
		 * 
		 */
		if (i < vertexNum && j < vertexNum && i >= 0 && j >= 0) {

			if (i == j) {
				return false;
			}

			/**
			 * 判断i的邻接结点集是否为空
			 */

			if (vector[i] == null) {
				vector[i] = new Vector();
			}

			/**
			 * 判断这条边是否存在，如果存在，则提示边已经存在
			 */
			for (int q = 0; q < vector[i].size(); q++) {

				if (((Integer) vector[i].get(q)).intValue() == j) {
					System.out.println("顶点" + i + "和" + "顶点" + j + "这两点之间存在边");
					return true;

				}
			}
		}
		return false;
	}

	/**
	 * 拓扑排序
	 */
	public void TopSort() {

		for (int i = 0; i < vertexNum; i++)
			if (in[i] == 0)
				stack.push(i);
		int k = 0;
		while (!stack.isEmpty()) {

			result[k] = (Integer) stack.pop();

			if (vector[result[k]] != null) {
				for (int j = 0; j < vector[result[k]].size(); j++) {

					int temp = (Integer) vector[result[k]].get(j);
					if (--in[temp] == 0) {
						stack.push(temp);
					}

				}

			}
			k++;

		}

		if (k < vertexNum) {
			System.out.println("有回路");

		}

	}

	/**
	 * 拓扑结果
	 * 
	 * @return
	 */
	public int[] getResult() {
		return result;

	}

}
