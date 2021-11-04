package com.squirrel.java.leet.数组.self;

public class 搜索旋转数组 {


    /**
     * 搜索旋转数组最小值
     *
     * @param nums   数组
     * @param target 目标
     * @return
     */
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {

            int mid = left + (right - left) / 2;
            // 不同条件判断
            // 数组1   数组2
            if (target == nums[mid]) {
                return mid;
            }
            // 同时落有序的歌数组上
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else if (target < nums[left] || target > nums[mid]) {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                // 落在不同的数组上    6 8 9 3 4 5

                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else if (target > nums[right] || target < nums[mid]) {
                    right = mid - 1;
                }
            }
        }
        return -1;

    }

}
