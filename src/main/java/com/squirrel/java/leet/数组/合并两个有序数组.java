package com.squirrel.java.leet.数组;

import java.util.Arrays;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年09月10日 09:12
 * @since 1.0
 */
public class 合并两个有序数组 {

    public static void main(String[] args) {


        merge(new int[]{5, 6, 3, 9, 0, 0, 0}, 4, new int[]{2, 1, 3}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // 简单方法 合并两个数组  并排序

        for (int i = 0; i != n; ++i) {

            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);

        System.out.println(Arrays.toString(nums1));

    }


    // 合并两个有序数组 使用双指针
    public static void mergePoint(int[] nums1, int m, int[] nums2, int n) {

        int p1 = 0;
        int p2 = 0;
        // 定义一个新数组
        int[] sorted = new int[m + n];
        while (p1 < m || p2 < n) {
            // 定义变量接收当前值
            int cur;
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            //
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; i++) {
            nums1[i] = sorted[i];
        }
    }


    public static void mergePointV1(int[] nums1, int m, int[] nums2, int n) {
        // 定义两个指针俩标记合并过程
        int p1 = 0;
        int p2 = 0;
        int[] sorted = new int[]{m + n};

        int j = 0;
        while (p1 < m || p2 < n) {

            int curr = 0;
            if (p1 == m) {
                curr = nums2[p2++];
            } else if (p2 == n) {
                curr = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                curr = nums1[p1++];
            } else {
                curr = nums2[p2++];
            }

            sorted[j++] = curr;
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];

        }


    }


    // 合并两个有序数组
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {

        int[] sorted = new int[m + n];
        // 使用双指针
        int p1 = 0;
        int p2 = 0;

        while (p1 != m || p2 != n) {
            // 定义临时变量 接数组的值
            int temp;
            if (p1 == m) {
                temp = nums2[p2++];
            } else if (p2 == n) {
                temp = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                temp = nums1[p1++];
            } else {
                temp = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = temp;
        }
        // 输出
        for (int i = 0; i < sorted.length; i++) {
            nums1[i] = sorted[i];
        }
    }
}
