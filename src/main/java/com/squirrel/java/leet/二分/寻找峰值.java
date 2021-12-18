package com.squirrel.java.leet.二分;

public class 寻找峰值 {


    /**
     * 思路:
     * 1.寻找峰值
     *
     * @param nums 数组
     * @return 数组中的最大值
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 当前元素比数组左面的都大、比数组右面的都小
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

    /**
     * 边界值处理
     *
     * @param nums  数组
     * @param index 索引
     * @return 带有边界值的数组结果
     */
    public int[] getIndex(int[] nums, int index) {
        if (index == -1 || index == nums.length) {
            return new int[]{0, 0};
        }
        return new int[]{1, nums[index]};
    }

    /**
     * 比较数组中具体的两个数的大小,由于getIndex 兼容了边界值
     * 所以需要如此判断
     *
     * @param nums  集合
     * @param left  元素下标 左
     * @param right 元素下标 右
     * @return left>right:1
     */
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
