package com.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 堆
 * 
 * @author chao
 *
 */
public class Heap {

	/**
	 * 递归实现 删除一个堆中一个数据的时候，根据堆的性质，应该把相应的位置下移，才能保持住堆性质不变
	 * 
	 * @param a
	 *            保持堆元素的数组
	 * @param index
	 *            被删除的那个节点的位置
	 */
	public static void heapDown(List heap, int index) {
		// 因为第一个位置存储的是空值，不在考虑之内
		int n = heap.size() - 2;

		// 记录最小的那个儿子节点的位置
		int child = -1;

		// 2*index>n说明该节点没有左右儿子节点了，那么就返回
		if (2 * index > n) {
			return;
		} // 如果左右儿子都存在
		else if (2 * index < n) {

			// 定义左儿子节点
			child = 2 * index;
			// 如果左儿子大于右儿子的数值，取右儿子的下标
			if ((Integer) heap.get(child) > (Integer) heap.get(child + 1)) {
				child++;
			}

		}// 如果只有一个儿子（左儿子节点）
		else if (2 * index == n) {
			child = 2 * index;
		}

		if ((Integer) heap.get(child) < (Integer) heap.get(index)) {
			// 交换堆中的child，和index位置的值
			swap(heap, child, index);

			// 完成交换后递归调用，继续下降
			heapDown(heap, child);
		}
	}

	// 非递归实现
	public static void heapDown2(List heap, int index) {
		int child = 0;// 存储左儿子的位置

		int temp = (Integer) heap.get(index);
		int n = heap.size() - 2;
		// 如果有儿子的话
		for (; 2 * index <= n; index = child) {
			// 获取左儿子的位置
			child = 2 * index;
			// 如果只有左儿子
			if (child == n) {
				child = 2 * index;
			} // 如果右儿子比左儿子的数值小
			else if ((Integer) heap.get(child) > (Integer) heap.get(child + 1)) {
				child++;
			}

			// 如果数值最小的儿子比temp的值小
			if ((Integer) heap.get(child) < temp) {
				// 交换堆中的child，和index位置的值
				swap(heap, child, index);
			} else {
				break;
			}
		}
	}

	/**
	 * 删除堆中最小的值，也就是删除位置是1的值，也就是根节点的值 操作原理是：当删除根节点的数值时，原来的位置就会出现一个孔
	 * 填充这个孔的方法就是，把最后的叶子的值赋给该孔，最后把该叶子删除
	 * 
	 * @param heap
	 */
	public static void deleteMin(List heap) {
		// 把最后的一个叶子的数值赋值给1个位置
		heap.set(1, heap.get(heap.size() - 1));
		// 下滤操作
		heapDown2(heap, 1);
		// heapDown(heap, 1);
		// 把最后一个位置的数字删除
		heap.remove(heap.size() - 1);
	}

	public static void main(String args[]) {
		List array = new ArrayList(Arrays.asList(null, 1, 2, 5, 10, 3, 7, 11, 15, 17, 20, 9, 15, 8, 16));
		// deleteMin(array);结果是2 3 5 10 9 7 11 15 17 20 16 15 8
		insert(array, 0);// 结果是0 2 1 10 3 7 5 15 17 20 9 15 8 16 11
		print(array);
	}

	// 打印链表
	public static void print(List list) {
		for (int i = 1; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	// 把堆中中的a,b位置的值互换
	public static void swap(List heap, int a, int b) {
		// 临时存储child位置的值
		int temp = (Integer) heap.get(a);

		// 把index的值赋给child的位置
		heap.set(a, heap.get(b));

		// 把原来的child位置的数值赋值给index位置
		heap.set(b, temp);
	}

	// 向堆中插入元素
	public static void insert(List heap, int value) {
		heap.add(value);
		// 开始上升操作
		heapUp2(heap, heap.size() - 1);
		// heapUp(heap, heap.size() - 1);

	}

	// 上升，让插入的数和父节点的数值比较，当大于父节点的时候就和节点的值相交换
	public static void heapUp(List heap, int index) {

		// 注意由于数值是从小标为一开始，当index = 1的时候，已经是根节点了
		if (index > 1) {
			// 保存父亲的节点
			int parent = index / 2;

			// 获取相应位置的数值
			int parentValue = (Integer) heap.get(parent);
			int indexValue = (Integer) heap.get(index);
			// 如果父亲节点比index的数值大，就交换二者的数值
			if (parentValue > indexValue) {
				// 交换数值
				swap(heap, parent, index);
				// 递归调用
				heapUp(heap, parent);
			}

		}
	}

	// 非递归实现
	public static void heapUp2(List heap, int index) {
		int parent;
		for (; index > 1; index /= 2) {
			// 获取index的父节点的下标
			parent = index / 2;

			// 获得父节点的值
			int parentValue = (Integer) heap.get(parent);
			// 获得index位置的值
			int indexValue = (Integer) heap.get(index);

			// 如果大于就交换
			if (parentValue > indexValue) {
				swap(heap, parent, index);
			}
		}
	}
}