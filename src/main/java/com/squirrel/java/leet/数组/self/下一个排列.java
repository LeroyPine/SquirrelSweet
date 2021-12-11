package com.squirrel.java.leet.数组.self;

public class 下一个排列 {


    /**
     * 思路:
     * <p>
     * 1.逆序查找第一个降序的数   2 7 5 6 4 3 2  ---> 2 7 4 5 6 3 2 --->  2 7 4 2 3 6 5
     * 2.交换 + 反转区间
     *
     * @param nums 数组
     */
    public void nextPermutation(int[] nums) {
        // 查找不是逆序的第一个元素
        int i = nums.length - 2;
        // 定位到不是逆序的第一个元素
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 继续向前查找第一个大于i下标处的元素,然后进行交换,最终在将其后面的序列进行反转
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 交换两个元素
            swap(nums, i, j);
        }
        // 在将i后面的元素进行反转
        reverse(nums, i + 1, nums.length - 1);


    }

    public void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }


    public void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }

    }
}
