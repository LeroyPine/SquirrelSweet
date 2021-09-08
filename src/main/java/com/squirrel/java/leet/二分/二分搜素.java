package com.squirrel.java.leet.二分;

public class 二分搜素 {


    /**
     * 二分搜索
     *
     * @param nums   数组
     * @param target 目标值
     * @return re
     */
    public int search(int[] nums, int target) {

        //
        int mid, left = 0;
        int right = nums.length - 1;

        // 1234  1 + 4  /2   2
        // 排序数组  12345678  查找7

        while (left <= right) {

            mid = left + (right - left) / 2;


            // 如果目标值小于中间值
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }


        return -1;
    }


}
