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
 * @date Created in 2021年09月26日 15:20
 * @since 1.0
 */
public class 二分查找 {


    /**
     * 思路:
     * 1.定义左区间、右区间
     * 2.左右指针相遇时即是元素的位置
     *
     * @param nums   数组
     * @param target 目标值
     * @return 目标值下标
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 二分的板子
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
