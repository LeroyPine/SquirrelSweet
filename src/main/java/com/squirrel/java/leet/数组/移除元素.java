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
 * @date Created in 2021年06月02日 16:39
 * @since 1.0
 */
public class 移除元素 {

    public static int removeElement(int[] nums, int val) {

        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            //c
            if (nums[i] == val) {
                cnt++;
            } else {
                nums[i - cnt] = nums[i];
            }
            //


        }
        return nums.length - cnt;
    }

    public static void main(String[] args) {

        int arr[] = new int[]{3, 2, 2, 3};
        int i = removeElement(arr, 3);
        System.out.println("长度:" + i);

    }
}
