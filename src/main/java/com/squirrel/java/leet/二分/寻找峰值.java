package com.squirrel.java.leet.二分;

public class 寻找峰值 {


    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (compare(nums, mid, mid - 1) > 0 && compare(nums, mid, mid + 1) > 0) {
                ans = mid;
                break;
            }
            if (compare(nums, mid, mid - 1) > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;

    }

    public int[] getIndex(int[] nums, int index) {
        if (index == -1 || index == nums.length) {
            return new int[]{0, 0};
        }
        return new int[]{1, nums[index]};
    }

    // 然后书写compare方法
    public int compare(int[] nums, int left, int right) {
        int[] nums1 = getIndex(nums, left);
        int[] nums2 = getIndex(nums, right);
        if (nums1[0] != nums2[0]) {
            return nums1[0] > nums2[0] ? 1 : -1;
        }
        if (nums1[1] == nums2[1]) {
            return 0;
        }
        return nums1[1] > nums2[1] ? 1 : -1;
    }

}
