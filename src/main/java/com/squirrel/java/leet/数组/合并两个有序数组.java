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

    // 合并两个有序数组 使用双指针
    public static void mergePoint(int[] nums1, int m, int[] nums2, int n) {

        // 采用双指针
        int p = 0;
        int q = 0;
        int[] sorted = new int[m + n];
        while (p < m || q < n) {
            int temp;
            if (p == m) {
                temp = nums2[q++];
            } else if (q == n) {
                temp = nums1[p++];
            } else if (nums1[p] <= nums2[q]) {
                temp = nums1[p++];
            } else {
                temp = nums2[q++];
            }
            sorted[p + q - 1] = temp;
        }

        for (int i = 0; i < sorted.length; i++) {
            nums1[i] = sorted[i];
        }

    }


}
