package com.squirrel.java.leet.二分;

public class 寻找有序数组的中位数 {

    /**
     * 思路:
     * 1.合并两个有序数组
     * 2.然后在有序数组中找到中位数
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p = 0;
        int q = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] sorted = new int[m + n];
        // 各自到达各个数组的边界时
        while (p != m || q != n) {
            int temp = 0;
            if (p == m) {
                temp = nums2[q++];
            } else if (q == n) {
                temp = nums1[p++];
            } else if (nums1[p] < nums2[q]) {
                temp = nums1[p++];
            } else {
                temp = nums2[q++];
            }
            sorted[p + q - 1] = temp;
        }
        // 选取中位数  偶数 == 中间两个值相加/2
        if (sorted.length % 2 == 0) {
            int i = sorted[sorted.length / 2 - 1];
            int j = sorted[sorted.length / 2];
            return (double) (i + j) / 2;
        } else {
            return sorted[sorted.length / 2];
        }

    }


    public double findMedianSortedArraysOther(int[] nums1, int[] nums2) {
        // 保证 nums1 一直比nums2短
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        //
        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;
        int left = 0;
        int right = m;
        while (left < right) {
            // 向上取整
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;

            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }
        int i = left;
        int j = totalLeft - left;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        // 证明为偶数
        if ((m + n) % 2 == 0) {
            return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
        } else {
            return Math.max(nums1LeftMax, nums2LeftMax);
        }


    }

}

