package com.squirrel.java.leet.数组;

import java.util.Arrays;
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
 * @date Created in 2021年09月10日 19:08
 * @since 1.0
 */
public class 数组中第K个最大的元素 {


    /**
     * 思路：
     * 1.快排思想:快排是将一个数组根据某个pivot切分成两部分,一部分小于pivot,一部分大于pivot
     * 2.可以通过快排找到对应 nums.length-k 的位置,那么这个位置就是我们要找的数组的第K个最大的元素
     * 3.核心：找到对应的pivot partition
     *
     * @param nums 数组
     * @param k    第k大元素
     * @return 返回第k大的元素
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSortK(nums, 0, nums.length - 1, nums.length - k);

    }


    public int quickSortK(int[] nums, int left, int right, int index) {
        int randomIndex = randomPartition(nums, left, right);
        if (randomIndex == index) {
            return nums[index];
        } else {
            if (randomIndex > index) {
                return quickSortK(nums, left, randomIndex - 1, index);
            } else {
                return quickSortK(nums, randomIndex + 1, right, index);
            }
        }
    }

    private int randomPartition(int[] nums, int left, int right) {
        Random random = new Random();
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, right, randomIndex);
        return partition(nums, left, right);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private int partition(int[] nums, int left, int right) {
        // 基准值选取下标为right的元素
        int pivot = nums[right];
        // i、j 为两个指针
        // 如果下标为j的数小于等于 基准值,那么
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        // 最终将基准值放入正确的位置
        swap(nums, i + 1, right);
        return i + 1;
    }


    public static void main(String[] args) {

        数组中第K个最大的元素 a = new 数组中第K个最大的元素();
        //  8个元素: 下标为  0  7
        int[] nums = new int[]{2, 5, 4};
        int partition = a.partition(nums, 0, 2);
        System.out.println(partition);
        System.out.println(Arrays.toString(nums));
    }
}
