package com.squirrel.java.arithmetic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

/**
 * <p></p>
 * <p>
 * <PRE>   排序算法
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年03月12日 08:50
 * @since 1.0
 */
@Slf4j
@Component
public class SortAlgorithm {



    /**
     * 冒泡排序:
     * <p>
     * 每个元素和相邻的元素进行比较,每次能取出最大和最小的
     *
     * @param array 数组
     */
    public static void bubbleSort(int[] array) {
        SortAlgorithm sortAlgorithm = new SortAlgorithm();



       /* if (Objects.isNull(array) || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            log.info("第{}轮比较,比较后的数组:{}", i + 1, Arrays.toString(array));
        }*/

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i-1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }

        }

        log.info("冒泡排序：result：{}", Arrays.toString(array));

    }

    /**
     * 选择排序:
     * 数组中的每个元素对数组中的所有元素进行一次比较
     * 一次遍历能够取出最小或者最大的数据
     *
     * @param array 数组
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < array.length - 1; j++) {
                // 每个元素在一轮比较中和所有元素去进行比较
                if (array[minIndex] > array[j + 1]) {
                    minIndex = j + 1;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        log.info("选择排序：result：{}", Arrays.toString(array));

    }


    /**
     * 插入排序
     * 当前元素与所有的元素进行比较,如果后面的元素按某种排序规则符合
     * 那么就移动到该元素的前面
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 当前元素
            int current = array[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && array[preIndex] > current) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        log.info("插入排序：result：{}", Arrays.toString(array));
    }


    public static void insertionSortV3(int[] array) {

        for (int i = 1, j; i < array.length; i++) {
            int num = array[i];
            // 循环比较
            for (j = i - 1; j >= 0 && array[j] > num; j++) {
                // swap
                array[j + 1] = array[j];
            }
            array[j + 1] = num;
        }
    }


    /**
     * 插入排序思想： 以第一个数为基准值,后面的元素与前面的元素依次进行比较,
     * <p>
     * 把一个新的元素插入到已排序好的数组  形成一个新的已排序好的数组
     * 从第一个元素开始  取下一个元素比较后实现排序,形成新的数组
     * 再取第三个元素与该数组进行比较   比较时候从该数组的最后一位开始进行比较
     *
     * @param array
     */
    public static void insertionSortSelf(int[] array) {
        // 遍历
        for (int i = 1; i < array.length; i++) {
            // 寄存器
            int current = array[i];
            int preIndex = i - 1;

            // 循环比较插入
            while (preIndex >= 0 && array[preIndex] > current) {
                // 进行交换
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;

        }

        log.info("插入排序：result：{}", Arrays.toString(array));
    }


    /**
     * 希尔排序： 在一个有序列上根据逻辑进行分组,对每一个分组进行插入排序
     *
     * @param array 数组
     */
    public static void shellSort(int[] array) {
        int len = array.length;
        for (int gap = len / 2; gap > 0; gap = gap / 3) {
            for (int i = gap; i < len; i++) {
                int preIndex = i - gap;
                int current = array[i];
                while (preIndex >= 0 && array[preIndex] > current) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex = preIndex - gap;
                }
                array[preIndex + gap] = current;
            }
        }
        log.info("希尔排序：result：{}", Arrays.toString(array));
    }


    /**
     * 快速排序:
     *
     * @param array
     */
    public static void quickSort(int array[], int left, int right) {
        if (left < right) {
            // 分区  排序
            int partitionIndex = partition(array, left, right);
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
    }

    /**
     * 获取基准值?
     *
     * @param array 数组
     * @param left  左下标
     * @param right 右下标
     * @return
     */
    public static int partition(int array[], int left, int right) {
        // 选取基准值 1.比基准值大的放在其右面,比基准值小的放在其左面
        int pivot = left;
        int index = pivot + 1;
        for (int i = left + 1; i <= right; i++) {
            if (array[pivot] > array[i]) {
                // 交换
                swap(array, index, i);
                index++;
            }
        }
        swap(array, pivot, index - 1);
        // 然后在进行partition ？
        return index - 1;
    }


    public static void swap(int array[], int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }


    public static void main(String[] args) {
        int[] array = {3, 7, 25, 21, 1, 9, 12};
        bubbleSort(array);
      /*  selectionSort(array);
        insertionSortSelf(array);
        shellSort(array);

        quickSort(array, 0, array.length - 1);*/

        System.out.println(Arrays.toString(array));
    }


}
