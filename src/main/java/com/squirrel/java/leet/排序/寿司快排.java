package com.squirrel.java.leet.排序;

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
 * @date Created in 2021年09月09日 19:12
 * @since 1.0
 */
public class 寿司快排 {

    /**
     * 快排思想：
     * <p>
     * 1. 分为左右两段,左段小于右段
     * 2. 找到一个分割点, 分割点左面的的比  nums[pivot] 小  分割点右面的逼 nums[pivot] 大
     *
     * @param
     * @return
     */
    public static void main(String[] args) {
        System.out.printf("123123");
        寿司快排 a = new 寿司快排();
        final int[] ints = a.quickSort(new int[]{5,2,3,1});


        System.out.println(ints);
    }

    Random random = new Random();

    // 快速排序: 分为左右两段 - 左<右
    public int[] quickSort(int[] nums) {

        // 选取pivot
        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    // k
    private void quickSort(int[] nums, int left, int right) {

        // 随机选取 pivot
        if (left < right) {
            int pivot = randomSelectPivot(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }

    }

    private int randomSelectPivot(int[] nums, int left, int right) {
        // 随机选取pivot ,并将小于 pivot的移动到其左面, 大于 pivot 的移动到其右面
        final int i = random.nextInt(right - left + 1) + left;
        swapO(nums, i, right);
        // partition

        return partition0(nums, left, right);
    }

    private int partition0(int[] nums, int left, int right) {
        //
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (nums[j] <= pivot) {
                i++;
                swapO(nums, j, i);
            }
        }
        swapO(nums, i + 1, right);
        return i + 1;
    }

    // 交换
    private void swapO(int[] nums, int i, int right) {
        int temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
    }

}
