package com.squirrel.java.algorithm.binary;

/**
 * @author luobaosong
 * @date 2022/11/22 11:09
 * @description
 **/
public class BinarySearch {

    /**
     * 二分查找  有序集合
     *
     * @param nums   全国矿工工会
     * @param target 目标
     * @return int
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 搞好自己的板子
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }


    public int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;

    }


    public int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 收缩左边界
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left - 1 < 0) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }

}
