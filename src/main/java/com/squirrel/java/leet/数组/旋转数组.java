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
 * @date Created in 2021年06月07日 18:48
 * @since 1.0
 */
public class 旋转数组 {

    public static void rotate(int[] nums, int k) {

        // 实际移动的坐标
        k = k % nums.length;
        // swap  all   [0~k-1]  [k~num.lem-1]

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }


    public static void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }

    }


    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 6, 7};
      /*  reverse(array, 0, 3);
        System.out.println(Arrays.toString(array));
        */


        rotate(array,2);
        System.out.println(Arrays.toString(array));
    }
}
