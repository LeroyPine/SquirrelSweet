package com.squirrel.java.leet.数组.self;

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
 * @date Created in 2021年09月26日 14:41
 * @since 1.0
 */
public class 下一个序列 {


    // 下一个序列
    public void nextPermutation(int[] nums) {

        // 1  2 5 4 3   1 1 5 3
        // 查找不是逆序的第一个元素
        int i = nums.length - 2;
        // 定位到不是逆序的第一个元素
        while (i >= 0 && nums[i] > nums[i + 1]) {
            i--;
        }

        // 继续向前找第一个大于i下标处的元素
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {

    }

    private void swap(int[] nums, int i, int j) {

    }
}
