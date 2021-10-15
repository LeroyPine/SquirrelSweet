package com.squirrel.java.arithmetic;

import java.util.Random;

import static com.squirrel.java.arithmetic.SortAlgorithm.swap;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年10月15日 11:01
 * @since 1.0
 */
public class QuickSort {

    Random random = new Random();

    /**
     * 快速排序
     *
     * @param array 数组
     * @return re
     */
    public int[] quickSort(int[] array) {
        //
        return quickSort(array, 0, array.length - 1);

    }

    private int[] quickSort(int[] array, int left, int right) {
        if (left < right) {
            // 分区  找到轴距
            int partitionIndex = partition(array, left, right);
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
        return new int[0];
    }

    // 分区
    private int partition(int[] array, int left, int right) {
        // 随机选取pivot

        if (left < right) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(array, randomIndex, right);
        }


        // 选取pivot
        int pivot = array[right];
        int i = left - 1;
        for (int j = i + 1; j < right; j++) {
            // 如果元素小于轴距 那么移动到该轴距的左侧
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        // 在进行交换将pivot 交换到正确的位置上
        swap(array, i + 1, right);
        return i + 1;
    }

    public void swap(int array[], int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}
