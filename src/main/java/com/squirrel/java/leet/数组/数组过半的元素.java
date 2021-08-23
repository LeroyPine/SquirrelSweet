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
 * @date Created in 2021年07月16日 14:03
 * @since 1.0
 */
public class 数组过半的元素 {


    public static void main(String[] args) {

        final int i = majorityElementV2(new int[]{1, 2, 2, 2, 3, 4});
        System.out.println(i);
    }

    //
    public static int majorityElement(int[] nums) {

        // 摩尔定律
        int count = 0;
        int major = 0;

        for (int num : nums) {

            if (count == 0) {
                major = num;
                count = 1;
            } else {
                int result = major == num ? 1 : -1;
                count = count + result;
            }
        }

        return major;
    }


    public static int majorityElementV2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length ; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        System.out.println(nums[nums.length / 2]);

        return nums[nums.length / 2];

    }
}
