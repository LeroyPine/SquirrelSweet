package com.squirrel.java.leet.数组.self;

public class 找出最后一个小于目标元素的索引 {


    public int getMinIndex(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            //找出小于目标元素 即为 目标元素大于mid下标的
            if (target > nums[mid]) {

                if (mid == right || nums[mid + 1] >= target) {
                    return mid;
                } else {
                    left = mid + 1;
                }

            } else {

                right = mid - 1;

            }

        }
        return -1;
    }
}
