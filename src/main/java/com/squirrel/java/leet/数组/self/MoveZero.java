package com.squirrel.java.leet.数组.self;

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
 * @date Created in 2021年05月13日 18:23
 * @since 1.0
 */
public class MoveZero {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 0, 0, 5};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void moveZeroes(int[] nums) {
        // 定义个游标
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果不为0,那么就当前下标
            if (nums[i] != 0) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        // 将idx之后的变为0,如果idx小于数组的长度,将生育的元素置为0
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
