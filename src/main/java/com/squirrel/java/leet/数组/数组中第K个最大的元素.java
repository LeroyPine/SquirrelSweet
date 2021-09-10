package com.squirrel.java.leet.数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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


    public int findKthLargest(int[] nums, int k) {

        // 排序
        Arrays.sort(nums);
        // set 集合
        Set<Integer> set = new HashSet();
        int j = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (j == k) {
                return nums[i];
            }
            j++;
        }
        return -1;

    }

    Random random = new Random();

    // 快速排序 第K大元素
    public int findKthLargestQuick(int[] nums, int k) {

        // 快排查询
        return quickSelect(nums, 0, nums.length - 1, k);

    }

    public int quickSelect(int[] nums, int left, int right, int index) {

        // 随机选取pivot
        int q = randomPartition(nums, left, right);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
        }

    }

    public int randomPartition(int[] nums, int left, int right) {
        final int p = random.nextInt(nums[right - left + 1]);
        // 交换基准值
        swap(nums, p, right);
        // partition
        return partition(nums, left, right);

    }

    private int partition(int[] nums, int left, int right) {
        int target = nums[right];
        int i = left - 1;
        for (int j = left; j < right - left; j++) {
            if (nums[i] <= target) {
                swap(nums, i++, right);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }


    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
