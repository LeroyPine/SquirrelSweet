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
 * @date Created in 2021年09月22日 18:21
 * @since 1.0
 */
public class 搜索旋转排序数组 {

    /**
     * 思路:
     * 1.旋转有序数组,找到其分割点,
     * 2.两面仍然是有序数组,此时可以对两个区间使用二分
     * // 判断逻辑   nums[0] <= nums[mid]
     * //           nums[0] <= target && target < nums[mid]              right = mid -1
     * //           nums[mid]< target && target <= nums[right]           left = mid +1
     * @param nums   数组
     * @param target 目标值
     * @return 下标
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        // 二分
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 选取中间节点
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            // 判断中间节点属于哪个区间？
            // 1 2 3 4 5 6      4 5 6 | 1 2 3           3 4 5 | 6 1 2
            if (nums[0] <= nums[mid]) {
                // 证明当前元素在左区间,对左区间使用二分查找
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}































