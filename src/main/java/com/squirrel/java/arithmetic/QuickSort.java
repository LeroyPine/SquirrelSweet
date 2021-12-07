package com.squirrel.java.arithmetic;

import java.util.Random;

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


    /**
     * 快速排序
     *
     * @param array 数组
     * @return re
     */
    public int[] sortArray(int[] array) {
        //
        quickSort(array, 0, array.length - 1);
        return array;
    }

    Random random = new Random();

    // 递归寻找pivot
    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int randomIdx = random.nextInt(right - left + 1) + left;
        swap(array, randomIdx, right);
        // 定义指针
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }


    public void swap(int array[], int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

}
