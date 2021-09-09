package com.squirrel.java.leet.排序;

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
        final int[] ints = a.quickSort(new int[]{7, 12, 3, 4, 6, 33, 1});


        System.out.println(ints);
    }


    public int[] quickSort(int[] nums) {

        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        // 下标小于结束
        if (start < end) {
            // 获取分割点
            int pivot = partition(nums, start, end);
            quickSort(nums, 0, pivot - 1);
            quickSort(nums, pivot + 1, end);

        }


    }

    // 分区
    private int partition(int[] nums, int start, int end) {

        // 选取基准值
        int target = nums[end];
        int i = start;
        // 将小于target的值移动到数组前面

        for (int j = start; j < end; j++) {
            if (nums[j] < target) {
                // 如果小于目标值  进行交换
                swap(nums, i, j);
                i++;
            }
        }
        // 基准值修正
        swap(nums, i, end);
        return i;
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

}
