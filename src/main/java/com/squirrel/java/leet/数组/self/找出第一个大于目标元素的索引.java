package com.squirrel.java.leet.数组.self;

public class 找出第一个大于目标元素的索引 {

    //  1  4 4  5  8  9 10
    // target

    public int getMaxIndex(int nums[], int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {


                // 如果走到数组最左侧  或者 中间点的前一个媛媛速
                if (mid == 0 || nums[mid - 1] <= target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

























}
