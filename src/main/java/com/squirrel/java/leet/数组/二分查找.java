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


    public int search(int[] nums, int target) {

        // 二分查找//
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return -1;


    }
}
