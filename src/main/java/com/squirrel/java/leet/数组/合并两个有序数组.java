package com.squirrel.java.leet.数组;

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

    /**
     * 思路:
     * 1. 采用双指针的方式
     * 2. 双指针进行++操作,加到m或者n
     * 3.
     *
     * @param nums1 数组1
     * @param m     数组长度 m
     * @param nums2 数组2
     * @param n     数组长度 n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = 0;
        int q = 0;
        // 定义排序数组
        int[] sorted = new int[m + n];
        while (p != m || q != n) {
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
        for (int i = 0; i < sorted.length; i++) {
            nums1[i] = sorted[i];
        }
    }


}
