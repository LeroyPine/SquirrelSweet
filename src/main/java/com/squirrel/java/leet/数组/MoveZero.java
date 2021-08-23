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
 * @date Created in 2021年05月13日 18:23
 * @since 1.0
 */
public class MoveZero {


    public static void main(String[] args) {

        int[] nums = new int[]{1, 0, 2, 0, 0, 5};
        moveZeroes(nums);
        System.out.println(nums);
    }


    public static void moveZeroes(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
