package com.squirrel.java.leet.数组;

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
 * @date Created in 2021年09月10日 19:08
 * @since 1.0
 */
public class 数组中第K个最大的元素 {

    public void main(String[] args) {
        final int kthLargest = findKthLargest(new int[]{1, 2, 5, 7, 3, 6}, 3);

        System.out.println(kthLargest);
    }


    public int findKthLargest(int[] nums, int k) {

        // 寻找数组中第K个最大的元素 可以利用快排中 pivot的思想,将 数组的左面小于pivot,右面大于
        return quickSortK(nums, 0, nums.length - 1, nums.length - k);

    }

    private int quickSortK(int[] nums, int left, int right, int index) {

        int pivot = randomPartition(nums, left, right, index);
        if (pivot == index) {
            return nums[index];
        } else {
            if (pivot < index) {
                return quickSortK(nums, pivot + 1, right, index);
            } else {
                return quickSortK(nums, left, pivot - 1, index);
            }
        }
    }

    Random random = new Random();

    private int randomPartition(int[] nums, int left, int right, int index) {

        int pivot = random.nextInt(right - left + 1) + left;

        swap(nums, pivot, right);

        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;

    }


}
