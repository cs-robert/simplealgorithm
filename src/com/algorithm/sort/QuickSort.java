package com.algorithm.sort;

/**
 * 快速排序
 *
 * @author chao
 */
public class QuickSort {
    /**
     * 快速排序
     *
     * @param num
     * @param left
     * @param right
     */
    public static void sort(int[] num, int left, int right) {
        if (left < right) {
            int dp = partition(num, left, right);
            sort(num, left, dp - 1);
            sort(num, dp + 1, right);
        }
    }

    /**
     * 数据分组
     *
     * @param num
     * @param left
     * @param right
     */
    public static int partition(int[] num, int left, int right) {
        int pivot = num[left];
        while (left < right) {
            while (left < right && num[right] >= pivot)
                right--;
            if (left < right)
                num[left++] = num[right];
            while (left < right && num[left] <= pivot)
                left++;
            if (left < right)
                num[right--] = num[left];
        }
        num[left] = pivot;

        return left;
    }

    public static void sortQ(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sortQ(array, left, i - 1);
        sortQ(array, i + 1, right);
    }

    public static void main(String[] args) {
        int[] num = {2, 5, 3, 1};
        sort(num, 0, num.length - 1);
        for (int i = 0; i < num.length; i++)
            System.out.print(num[i] + " ");

    }

}
