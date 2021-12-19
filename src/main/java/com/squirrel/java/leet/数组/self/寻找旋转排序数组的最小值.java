package com.squirrel.java.leet.数组.self;

public class 寻找旋转排序数组的最小值 {


    /**
     * 思路:
     * 1.二分思想
     * 2.利用数组的最后一个元素进行二分
     * 3.边界: left < right
     *
     * @param nums 数组
     * @return 最小值下标
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 寻找中位数
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = left + 1;
            }
        }
        return nums[left];
    }

}
