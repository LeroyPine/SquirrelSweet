package com.squirrel.java.leet.数组;

public class 寻找有序数组中位数 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p = 0;
        int q = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] sorted = new int[m + n];
        while (p < m || q < n) {
            int temp;
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
        int index = (m + n) / 2 -1;
        int ind = index + 1;
        //
        if ((m + n) % 2 == 0) {

            int i = sorted[ind] + sorted[index];
            return (double) i / 2;
        } else {

            return sorted[index];
        }

    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }
}
