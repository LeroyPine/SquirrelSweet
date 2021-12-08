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
 * @date Created in 2021年09月23日 14:25
 * @since 1.0
 */
public class 接雨水 {


    /**
     * 说实话 我不理解。
     * 双指针： 从左往右遍历找到最大的值，
     * 从右往左遍历找到最大的值。
     * <p>
     * 两个数组相减的到最终的雨水
     * <p>
     * 双指针感受一下  接雨水
     */

    public int trapDpoint(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        // left right
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // leftMax
            if (height[left] < leftMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
